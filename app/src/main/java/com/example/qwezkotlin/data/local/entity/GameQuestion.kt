package com.example.qwezkotlin.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class GameQuestion(
    @Embedded
    val game: Game,

    @Relation(parentColumn = "id", entityColumn = "question_id")
    val questions: List<Question>
)



