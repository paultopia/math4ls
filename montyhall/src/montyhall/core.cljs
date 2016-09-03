(ns montyhall.core
  (:require [reagent.core :as reagent :refer [atom]]))

(def win-stubborn (atom 0))
(def loss-stubborn (atom 0))

(def win-switcher (atom 0))
(def loss-switcher (atom 0))

(def win-random (atom 0))
(def loss-random (atom 0))

(defn find-remaining
  "Simulates opening (and thus eliminating) one of the goat doors, and
  returns the remaining closed door, which player can switch to.

  If player's first guess is goat, open other goat door, and return car as last
  closed door.  If player's first guess is car, open one of the two goat doors and return other goat door as last closed door. "
  [first-guess]
  (if (= first-guess :car) :goat :car))

(defn apply-strategy
"Apply the given strategy. If stubborn, always stick with first guess. If switcher, always switch doors. If random, pick randomly between first guess and remaining door."
  [strategy first-guess remaining]
  (case strategy
    :stubborn first-guess
    :switcher remaining
    :random (rand-nth [first-guess remaining])))

(defn play-monty
  "Play one round of the monty hall game"
  [strategy win-atom loss-atom]
  (let [first-guess (rand-nth [:goat :goat :car])
        remaining (find-remaining first-guess)
        result (apply-strategy strategy first-guess remaining)]
    (cond
      (= result :car) (swap! win-atom inc)
      :else (swap! loss-atom inc))))

(defn lotsa-monty
"Play 10000 rounds of a monty hall game with 1ms delay between rounds (to visualize incrementally in graphs)"
  [strategy win-atom loss-atom]
  (do
    (reset! win-atom 0)
    (reset! loss-atom 0)
    (dotimes [n 10000]
      (js/setTimeout #(play-monty strategy win-atom loss-atom) n))))

(defn wl-chart [w l caption]
  (let [win-ratio (* 200 (/ w (+ w l)))
        lose-ratio (- 200 win-ratio)]
    [:div
     [:figure
      [:figcaption (str caption ": win: " w " loss: " l)]
      [:svg {:class "chart" :width 150 :height 210}
       [:g {:transform "translate(0,0)"}
        [:rect {:width 30 :height win-ratio :y lose-ratio}]
        [:text {:y 210 :x 20} "win"]]
       [:g {:transform "translate(35,0)"}
        [:rect {:width 30 :height lose-ratio :y win-ratio}]
        [:text {:y 210 :x 25} "loss"]]]]]))

(defn monty-page []
  [:div
   [:h3 "Probability for Law Students: the Monty Hall Problem"]
   [:p "There's a famous puzzle called the \"Monty Hall Problem.\" It goes like this: imagine you're in a game show, and the host invites you to pick from three closed doors.  One of the doors holds a fancy new sports car, and the other two hold goats.  (Let us suppose, perhaps counterfactually, that you prefer a sports car to a goat.) After you choose, the host opens one of the OTHER doors, always to reveal a goat."]
   [:p "So now you've picked a door, and the host shows you a goat behind one of the other doors. Importantly, the host knows what door has the car, and s/he always opens a door you didn't choose, and it's always a goat door. Then the host asks if you want to stick with your original choice, or switch to the remaining closed door. If you want to get the sports car, should you stay or switch?"]
   [:p "Back in 1990, Marilyn vos Savant, who apparently occupies the spot in the Guinness World Record book for \"highest IQ,\" published this problem in a magazine, and declared that the correct answer was to always switch. In response, many, many people, including a number of mathematicians, blew their stacks and wrote "  [:a {:href "http://marilynvossavant.com/game-show-problem/"} "angry letters telling her how wrong she was."]]
   [:p "Here's how you might (incorrectly) reason to conclude that she was wrong. At the start of the game, each door had a .33[3333...] chance of having the sports car behind it. Initially, you picked a door at random, so you have a .33 chance of being right to stick. The remaining door also had a .33 chance of being the one with a sports car behind it. Nothing about what the host did changed those probabilities, so you have an equal chance of getting the sports car whether you stick with your original choice or switch."]
   [:p "By contrast, here's the correct way to reason. The host actually gave you additional information when s/he opened the door. Originally, your choice (call it the A-door) had a .33 chance of being correct, and hence a .66[6666666...] chance of the sports car being in one of the two remaining doors (call them the B-doors).  So now the host has ruled out one of the B-doors for you, you still know that there's a .33 chance of the car being behind the A-door and a .66 chance of the car being behind the B-doors... but the number of B-doors has been reduced from 2 to 1!  So there's a .66 chance of the car behind behind the one door left.  You should switch. To see a mathematical explanation of this answer using Bayes' rule, " [:a {:href "http://angrystatistician.blogspot.com/2012/06/bayes-solution-to-monty-hall.html"} "go look at this blog post."]]
   [:p "This is a " [:a {:href "http://philpapers.org/rec/KRATPO-13"} "famously difficult problem, and the vast majority of people initially tend to pick the wrong answer. "] "It tends to break our ordinary intuitions, and as a result serves as an excellent demonstration of the fact that you really can't trust your intuitive judgments when it comes to probability."]
   [:p "But you don't have to believe me.  I've written a computer simulation, below, that plays the Monty Hall game 10,000 times each for three different strategies and displays the ratio of wins (sports cars) to losses. You can see the code to produce it " [:a {:href "https://github.com/paultopia/math4ls/tree/master/montyhall"} "here, "] "and you can play it yourself below."]
   [:div
    [:hr]
    [:p "First is the stubborn strategy.  A stubborn player will stick with their first choice no matter what. "]
     [:button {:on-click #(lotsa-monty :stubborn win-stubborn loss-stubborn)} "Play Stubborn"]
    [wl-chart @win-stubborn @loss-stubborn "Stubborn"]]
   [:div
    [:hr]
    [:p "Next is the switcher strategy. A switcher player will switch to the remaining door no matter what. "]
     [:button {:on-click #(lotsa-monty :switcher win-switcher loss-switcher)} "Play Switcher"]
    [wl-chart @win-switcher @loss-switcher "Switcher"]]
   [:div
    [:hr]
    [:p "Finally, let's look at a random strategy. In this strategy, we'll just flip a coin and pick a door at random. "]
     [:button {:on-click #(lotsa-monty :random win-random loss-random)} "Play Random"]
    [wl-chart @win-random @loss-random "Random"]]
   [:hr]
   [:p "As you can see, the switch strategy dominates the others, and, as expected, it wins about 2/3 of the time. What about the random strategy? Well, .5 of the time it made a choice with a .66 payoff, and .5 of the time it made a choice with a .33 payoff. (.5 * .33) + (.5 * .66) = .5, and, as expected, it gets about a 50% win rate."]
   [:p "You can run this simulation as many times as you want, just by clicking the buttons again."]
   [:hr]
   [:p "(c) Paul Gowder, 2016. Content under "  [:a {:href "http://creativecommons.org/licenses/by/4.0/"} "CC-Attribution-International-4.0 license"] ", code under " [:a {:href "https://opensource.org/licenses/MIT"} "MIT license."]]])

(defn mount-root []
  (reagent/render [monty-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
