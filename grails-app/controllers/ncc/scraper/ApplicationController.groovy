package ncc.scraper

class ApplicationController {

    def index() {
        def numbers = []
        def questions = []
        def answers = []
        def verseReferences = []
        def verses = []

        52.times {
            def number = it+1
            def content = "http://www.newcitycatechism.com/q-parent/q${number}.php".toURL().text

            def questionRegex = /(?ms)<h1.*?>(.*)<\/h1>/
            def answerRegex = /(?ms)<div class="answer .*?>(.*?)<\/div>/
            def verseReferenceRegex = /(?ms)<h2>(.*?)<\/h2>/
            def verseRegex = /(?ms)<div class="esv">(.*?)<\/div>/

            def questionMatcher = (content =~ questionRegex)
            def answerMatcher = (content =~ answerRegex)
            def verseReferenceMatcher = (content =~ verseReferenceRegex)
            def verseMatcher = (content =~ verseRegex)

            println number

            numbers.add(number)
            questions.add(questionMatcher[0][1])
            answers.add(answerMatcher[0][1])
            verseReferences.add(verseReferenceMatcher[0][1])
            verses.add(verseMatcher[0][1])
        }

        render view: "/index", model: [
                numbers: numbers,
                questions: questions,
                answers: answers,
                verseReferences: verseReferences,
                verses: verses]
    }
}
