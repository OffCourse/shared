(ns shared.protocols.convertible)

(defprotocol Convertible
  "The Convertible protocol allows data structures to be converted to others
  after they are checked against their specification"
  (-to-model        [this])
  (-to-event        [this])
  (-to-events       [this])
  (-to-query        [this])
  (-to-es-query     [this])
  (-to-bookmark     [this])
  (-to-bookmarks     [this])
  (-to-payload      [this])
  (-to-action       [this])
  (-to-clj          [this])
  (-to-credentials   [this])
  (-to-viewmodel    [this])
  (-to-route        [this])
  (-to-url          [this routes] [this course routes]))

(defn to-credentials
  "Converts the given data to an auth-token, if the object meets the
  corresponding model specification"
  [this] (-to-credentials this))

(defn to-bookmark
  "Converts the given data and offcourse bookmark, if the object meets the
  corresponding model specification"
  [this] (-to-bookmark this))

(defn to-bookmarks
  "Converts the given data to offcourse bookmarks, if the data meets the
  corresponding model specification"
  [this] (-to-bookmarks this))

(defn to-model
  "Converts raw data to one or more offcourse models, if the object meets the
  corresponding model specification"
  [this] (-to-model this))

(defn to-events
  "Converts an js api event to an offcourse event, if the object meets the
  corresponding model specification"
  [this] (-to-events this))

(defn to-event
  "Converts an js api event to an offcourse event, if the object meets the
  corresponding model specification"
  [this] (-to-event this))

(defn to-action
  "Converts an js api action to an offcourse action, if the object meets the
  corresponding model specification"
  [this] (-to-action this))

(defn to-query
  "Converts an js object to an offcourse query, if the object meets the
  corresponding model specification"
  [this] (-to-query this))

(defn to-es-query
  "Converts an offcourse query to an elasticsearch query, if the object meets the
  corresponding model specification"
  [this] (-to-es-query this))

(defn to-payload
  "Converts an js object to an offcourse query, if the object meets the
  corresponding model specification"
  [this] (-to-payload this))

(defn to-url
  "Given a set of routes, it converts a model to a url"
  ([this routes] (-to-url this routes))
  ([this course routes] (-to-url this course routes)))

(defn to-clj
  "converts javascript data to its cljs equivalent"
  ([this] (-to-clj this)))

(defn to-viewmodel
  "Given the provided route-params, it returns a viewmodel"
  ([this] (-to-viewmodel this)))

(defn to-route
  "Given the provided viewmodel, it returns the route-params"
  ([this] (-to-route this)))
