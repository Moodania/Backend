const url = "ws://localhost:8080/test";
var socket = null
    //socket.close();
var textBox = document.getElementById("textbox");
var textValue = document.getElementById("textfield");
const connectButton = document.getElementById("connectButton");
const sendButton = document.getElementById("sendButton");

connectButton.addEventListener("click", function (event) {
    if (connectButton.textContent === "Connect") {
        socket = createSocket(url)
        connectButton.textContent = "Disconnect";
    } else {
        connectButton.textContent = "Connect";
        if (socket.readyState === 1)
            socket.close();
    }
    console.log(socket.readyState);


});

sendButton.addEventListener("click", function (event) {
    const text = textValue.value;
    socket.send(text);
});

document.getElementById("checkStateButton").addEventListener("click", function (event){
    textBox.textContent += "\n" + socket.readyState;
})
function createSocket(url) {
    var newSocket = new WebSocket(url);

    newSocket.onmessage = (event) => {
        textBox.textContent += "\n" + event.data;
        console.log(event.data);
    };

    newSocket.onopen = (event) =>{
        textBox.textContent += "\n connection established";
    }

    return newSocket;
}