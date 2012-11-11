(ns bowling-kata.core-test
  (:use clojure.test
        bowling-kata.core))

(deftest test-score-game
  (testing "bowling scores"
	   (is (= 0 (score-game (repeat 20 0)))) ; gutters
	   (is (= 20 (score-game (repeat 20 1)))) ; not spares
	   (is (= 26 (score-game (concat [10 5 3] (repeat 17 0)))))
	   (is (= 30 (score-game [10 10 10])))
	   (is (= 60 (score-game [10 10 10 10])))
	   (is (= 300 (score-game (repeat 12 10))))
	   (is (= 299 (score-game (concat (repeat 11 10) [9]))))
	   (is (= 100 (score-game (take 20 (cycle [0 10])))))
	   (is (= 279 (score-game (concat (repeat 9 10) [9 1 10]))))))

(deftest test-balls-to-score
  (testing "how many balls count for this frame's score?"
	   (is (= 2 (balls-to-score [5 4 9])))
	   (is (= 3 (balls-to-score [5 5 1])))
	   (is (= 3 (balls-to-score [10 9 0])))
	   (is (= 2 (balls-to-score [0 0 3])))
	   ;; handling the special last-frame cases
	   (is (= 3 (balls-to-score [10 10 10])))
	   (is (= 2 (balls-to-score [10 10])))))

(deftest test-balls-in-frame
  (testing "how many balls are in the next frame?"
	   (is (= 2 (balls-in-frame [3 2 10])))
	   (is (= 3 (balls-in-frame [10 1 1])))
	   (is (= 3 (balls-in-frame [10 10 10])))
	   (is (= 1 (balls-in-frame [10 10 10 10])))))
	       
(deftest test-spare?
  (testing "is it a spare?"
	   (is (true? (spare? [5 5 1])))))

(deftest test-last-frame?
  (testing "is it the last frame?"
	   (is (true? (last-frame? [10 10 10])))
	   (is (false? (last-frame? [10 5 5 5])))))