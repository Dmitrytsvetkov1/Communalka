package com.example.communalka.controllers

import co.yml.charts.common.model.Point
import kotlin.random.Random



fun getPointsList(): List<Point> {

    val list = ArrayList<Point>()

    for (i in 0..30){
        list.add(
            Point(
                i.toFloat(),
                Random.nextInt(500, 1000).toFloat()
            )
        )
    }
    return list
}