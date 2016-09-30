(ns shared.models.appstate.get
  (:refer-clojure :exclude [get -reset remove])
  (:require [shared.models.appstate.paths :as paths]
            [shared.protocols.specced :as sp]
            [shared.protocols.loggable :as log])
  (:require-macros [com.rpl.specter.macros :refer [select-first]]))

(defmulti get (fn [_ query]
                (sp/resolve query)))

(defmethod get :course [{:keys [courses] :as ds} course]
  (select-first (paths/course course) courses))

(defmethod get :checkpoint [{:keys [courses] :as ds} {:keys [checkpoint]}]
  (select-first (paths/checkpoint checkpoint) courses))

(defmethod get :resource [{:keys [resources] :as ds} query]
  (select-first (paths/resource query) resources))