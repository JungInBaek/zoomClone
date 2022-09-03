const messageList = document.querySelector("ul");
const messageForm = document.querySelector("#message");
const nicknameForm = document.querySelector("#nickname");
const socket = new WebSocket(`ws://${window.location.host}/ws`);

function makeMessage(type, payload) {
    const msg = {type, payload}
    return JSON.stringify(msg);
}

socket.addEventListener("open", () => {
    console.log("서버 접속 ✅");
});

socket.addEventListener("message", (message) => {
    const li = document.createElement("li");
    li.innerText = JSON.parse(message.data);
    messageList.append(li);
});

socket.addEventListener("close", () => {
    console.log("서버 접속 해제 ❌");
});

function handleSubmit(event) {
    event.preventDefault();
    const input = messageForm.querySelector("input");
    socket.send(makeMessage("MESSAGE", input.value));
    input.value = "";
}

function handleNickSubmit(event) {
    event.preventDefault();
    const input = nicknameForm.querySelector("input");
    socket.send(makeMessage("NICKNAME", input.value));
}

messageForm.addEventListener("submit", handleSubmit);
nicknameForm.addEventListener("submit", handleNickSubmit)