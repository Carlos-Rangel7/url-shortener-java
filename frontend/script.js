document.addEventListener("DOMContentLoaded", function() {
    const urlInput = document.getElementById('url-input');
    const shortenBtn = document.getElementById('shorten-btn');
    const clearBtn = document.getElementById('clear-btn');
    const shortenedUrlInput = document.getElementById('shortened-url');
    const copyBtn = document.getElementById('copy-btn');
    const messageContainer = document.getElementById('message-container');

    shortenBtn.addEventListener('click', function(event) {
        event.preventDefault();

        if (urlInput.value) {
            fetch("https://encurtador-qbln.onrender.com/urls/shorten", {
                method: "POST",
                headers: {
                    'Content-Type': "application/json",
                },
                body: JSON.stringify({ originalUrl: urlInput.value })
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error("Erro na requisição: " + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                const shortenedUrl = "https://encurtador-qbln.onrender.com/urls/shorten/${data.shortenedCode}";
                shortenedUrlInput.value = shortenedUrl;
                copyBtn.style.display = 'inline';

                if (data.shortenedCode) {
                    shortenedUrlInput.style.cursor = 'pointer';
                    shortenedUrlInput.onclick = function() {
                        window.open(shortenedUrl, '_blank');
                    };
                } else {
                    shortenedUrlInput.style.cursor = 'not-allowed';
                    shortenedUrlInput.onclick = null;
                }
            })
            .catch(error => {
                console.error("Erro ao encurtar URL:", error);
                showMessage("Erro ao encurtar URL. Tente novamente!", "error");
            });
        } else {
            showMessage('A URL não pode estar nula ou vazia', "error");
        }
    });

    clearBtn.addEventListener('click', function() {
        urlInput.value = '';
        shortenedUrlInput.value = '';
        shortenedUrlInput.style.cursor = 'not-allowed';
        shortenedUrlInput.onclick = null;
        copyBtn.style.display = 'none';
    });

    copyBtn.addEventListener('click', function() {
        navigator.clipboard.writeText(shortenedUrlInput.value)
            .then(() => {
                showMessage('URL copiada para a área de transferência!', "success");
            })
            .catch(error => {
                console.error("Erro ao copiar URL:", error);
                showMessage("Erro ao copiar URL. Tente novamente!", "error");
            });
    });

    function showMessage(message, type) {
        const messageBox = document.createElement('div');
        messageBox.textContent = message;
        messageBox.classList.add(type === "error" ? "error-message" : "success-message");

        messageContainer.innerHTML = '';
        
        messageContainer.appendChild(messageBox);

        setTimeout(() => {
            messageBox.remove();
        }, 4000);
    }
});