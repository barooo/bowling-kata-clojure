# bowling-kata

Uncle Bob's bowling kata in clojure.

I'm not 100% happy with this but I think that the tests are green and
complete.  I feel like the main loop is nice and I like that the
special case handling for the last frame is not in the main loop, but
last-frame? and strike? and spare? are awfully similar and there may
just be too many predicates in general.

The tests are probably not idiomatic and some of them are probably
unnecessary, but they actually reflect the path I took to get here.
