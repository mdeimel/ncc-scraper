<!DOCTYPE html>
<html>
	<head>
		<style type="text/css">
            body {
                font-family: Helvetica, Arial, sans-serif;
            }
            .highlight {
                color: #c8723b;
            }
		</style>
	</head>
	<body>
        <g:each in="${numbers}" var="number">
            <b>Q${number} ${questions[number-1].encodeAsRaw()}</b>
            ${answers[number-1].encodeAsRaw()}
            <b>${verseReferences[number-1].encodeAsRaw()}</b>
            ${verses[number-1].encodeAsRaw()}
            <br><br>
        </g:each>
	</body>
</html>