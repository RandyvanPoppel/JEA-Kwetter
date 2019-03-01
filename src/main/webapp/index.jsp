<html>
<head>
    <title>POC</title>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
</head>
<body>
<h2>Hello World!</h2>
<button id="pingBtn">PingController [AJAX: ping]</button>
<button id="addKweeterBtn">KweeterController [AJAX: addKweeter]</button>

<script>
    $('#pingBtn').on('click', function () {
        console.log("Button pressed");
        $.ajax({
            url: "/JEA-Kwetter-1.0/api/ping",
            dataType: "json",
            method: "GET",
            success: function (result) {
                console.log(result);
            }
        });
    });

    $('#addKweeterBtn').on('click', function () {
        console.log("Button pressed");
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "/JEA-Kwetter-1.0/api/kweeter/add",
            dataType: "json",
            method: "POST",
            data: {"username": "test1"},
            success: function (result) {
                console.log(result);
            }
        });
    });
</script>

</body>
</html>
