const socket = new WebSocket(`ws://${window.location.host}/ws/chat`);

socket.addEventListener("open", () => {
    console.log("서버 접속 ✅");
});

socket.addEventListener("message", (message) => {
    console.log("Just got this: ", message.data, " from the Server");
});

socket.addEventListener("close", () => {
    console.log("서버 접속 해제 ❌");
});

setTimeout(() => {
    socket.send("hello form the browser!");
}, 10000);