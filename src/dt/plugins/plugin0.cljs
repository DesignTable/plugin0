(ns dt.plugins.plugin0
  (:require [lt.object :as object]
            [lt.objs.command :as cmd]
            [lt.objs.tabs :as tabs])
  (:require-macros [lt.macros :refer [behavior defui]]))

(defui plugin0-panel [this]
  [:h1 "Plugin0: Hello!"])

; from browser
(behavior ::destroy-on-close
                  :triggers #{:close}
                  :reaction (fn [this]
                              ;(println "p0 destroy")
                              (object/destroy! this)))

(object/object* ::plugin0.panel
                :tags [:plugin0.panel]
                :name "plugin0"
                :init (fn [this]
                        (plugin0-panel this)))

(cmd/command {:command ::start-plugin0
              :desc "plugin0: Raise window"
              :exec (fn []
                      (println "start p0")
                      (tabs/add-or-focus! (object/create ::plugin0.panel)))})
