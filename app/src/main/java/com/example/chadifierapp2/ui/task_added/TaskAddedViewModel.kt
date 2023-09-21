package com.example.chadifierapp2.ui.task_added

import androidx.lifecycle.ViewModel

class TaskAddedViewModel: ViewModel() {
    private var pointsEarned: Int = 0

    fun setPointsEarned(points: Int) {
        pointsEarned = points
    }

    fun getPointsEarned(): Int {
        return pointsEarned
    }
}