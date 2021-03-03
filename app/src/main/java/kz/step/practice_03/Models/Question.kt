package kz.step.practice_03.Models

public class Question(_question: String, _answers: List<String>, _indexTrueAnswer: Int) {

    public var question: String? = null
    public var answers: List<String?>? = null
    public var indexTrueAnswer: Int? = null

    init {
        question = _question
        answers = _answers
        indexTrueAnswer = _indexTrueAnswer
    }




}