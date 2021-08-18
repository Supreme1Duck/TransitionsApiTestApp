package com.example.transitionsapitestapp.utils

import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeTransform
import androidx.transition.TransitionSet

class CatsTransition: TransitionSet() {

    init {
        setOrdering(ORDERING_TOGETHER)
            .addTransition(ChangeBounds())
            .addTransition(ChangeTransform())
            .addTransition(ChangeImageTransform())
            .setDuration(750)
    }

}