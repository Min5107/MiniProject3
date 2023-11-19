document.getElementById('main-chatbot-sendButton').addEventListener('click', chatGPT);

function chatGPT() {
    console.log("click!");
    const apiKey = "APIKEY"; // <- API KEY 입력
    const sendfield = document.getElementById('main-chatbot-sendfield').value;
    const result = document.getElementById('chatbotTextarea');
    const messages = [
        { role: 'system', content: 'You are a helpful assistant.' },
        { role: 'user', content: sendfield + '레시피 한국어로 만들어줘.' },
    ];

    const data = {
        model: 'gpt-3.5-turbo',
        temperature: 0.5,
        n: 1,
        messages: messages,
    };

    fetch("https://api.openai.com/v1/chat/completions", {
        method: 'POST',
        headers: {
            'Authorization': 'Bearer ' + apiKey,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(response => {
            console.log(response);

            result.value = "\n" + response.choices[0].message.content;
            adjustTextareaHeight(result);

            document.getElementById('main-chatbot-sendfield').value = '';
        })
        .catch(error => {
            console.error('Error:', error);

        });
}