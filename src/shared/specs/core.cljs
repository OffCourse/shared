(ns shared.specs.core
  (:require [cljs.spec :as spec]
            [shared.specs.event :as event]
            [shared.specs.base :as base]
            [shared.specs.query :as query]
            [shared.specs.action :as action]
            [shared.specs.payload :as payload]
            [shared.specs.course :as course]
            [shared.specs.resource :as resource]
            [shared.specs.bookmark :as bookmark]
            [shared.specs.auth :as auth]))

(spec/def ::query ::query/query)
(spec/def ::payload ::payload/payload)

(spec/def ::event ::event/event)
(spec/def ::action ::action/action)

(spec/def ::course ::course/course)
(spec/def ::resource ::resource/resource)
(spec/def ::bookmark ::bookmark/bookmark)

(spec/def ::spec spec/spec?)
(spec/def ::meta (spec/keys :req-un [::spec]))
(spec/def ::user (spec/keys :req-un [::base/user-name]))

(spec/def ::single-or-multiple? (spec/or :single map?
                                         :multiple (spec/coll-of map?)))

(spec/def ::credentials ::auth/credentials)

(def action-types action/types)
