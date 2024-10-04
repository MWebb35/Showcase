const char htmlonOffButtons[] PROGMEM = R"=====(
<html>

<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Basic Page</title>

    <style>
    button {
    background-color: #4caeac;
    border: none;
    color: white;
    padding: 16px 40px;
    border-radius: 10px;
    text-decoration: none;
    font-size: 30px;
    margin: 10px;
    cursor: pointer;}

    </style>
</head>

<body>
    <div class="container">
        <p>Use the buttons below to turn the LED on and off</p>

        <form action="/" method='POST'>
          <button name="ON" type="submit" value="1">On</button><br>
          <button name="OFF" type="submit" value="1">Off</button><br>
        </form>

    </div>
</body>

</html>
)=====";
