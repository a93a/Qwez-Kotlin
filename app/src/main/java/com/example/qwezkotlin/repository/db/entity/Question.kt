package com.example.qwezkotlin.repository.db.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE


@Entity(tableName = "questions", foreignKeys = [ForeignKey(entity = Game::class,
    parentColumns = ["id"],
    childColumns = ["question_id"],
    onDelete = CASCADE)]
)
data class Question @JvmOverloads constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "question_id")
    val qId: Int,

    @ColumnInfo(name = "question")
    val question: String,

    @ColumnInfo(name = "correct_answer")
    val correctAnswer: String,

    @ColumnInfo(name = "wrong_answer_one")
    val wrongAnswer1: String,

    @ColumnInfo(name = "wrong_answer_two")
    val wrongAnswer2: String,

    @ColumnInfo(name = "wrong_answer_three")
    val wrongAnswer3: String,

    @ColumnInfo(name = "answer_chosen")
    val answerChosen: String,

    @Ignore
    val number: String = ""
)