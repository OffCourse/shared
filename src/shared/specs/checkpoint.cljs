(ns shared.specs.checkpoint
  (:require [cljs.spec :as spec]
            [shared.specs.base :as base]))

(defn task-length [str]
  (>= (count str) 6))

(spec/def ::task string?)
(spec/def ::checkpoint-id (spec/and string? #(task-length %)))

(spec/def ::complete? boolean?)

(spec/def ::new-checkpoint (spec/and (spec/keys :req-un [::task ::resource-url])))
(spec/def ::resource-url ::base/url)

(spec/def ::checkpoint (spec/keys :req-un [::task ::resource-url ::checkpoint-id]
                                  :opt-un [::complete?]))

(spec/def ::checkpoints (spec/* ::checkpoint))
(spec/def ::new-checkpoints (spec/* ::new-checkpoint))
