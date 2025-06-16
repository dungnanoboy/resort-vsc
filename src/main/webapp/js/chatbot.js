class DunhuthChatbot {
    constructor() {
        this.apiKey = 'AIzaSyCFhG1QjuUIJuFFEswOix7fcArUYKbk3VY'; // Thay thế bằng API key thực tế
        this.apiUrl = 'https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent';
        this.isOpen = false;
        this.init();
    }    init() {
        console.log('Initializing Dunhuth Chatbot...');
        this.createChatbotHTML();
        this.bindEvents();
        this.addWelcomeMessage();
        console.log('Chatbot initialized successfully!');
    }

    createChatbotHTML() {
        const chatbotHTML = `
            <div class="chatbot-container">
                <button class="chatbot-toggle" id="chatbot-toggle">
                    <i class="fa fa-comments"></i>
                </button>
                <div class="chatbot-window" id="chatbot-window">
                    <div class="chatbot-header">
                        <h4><i class="fa fa-user"></i> Dunhuth Assistant</h4>
                        <button class="chatbot-close" id="chatbot-close">×</button>
                    </div>
                    <div class="chatbot-messages" id="chatbot-messages">
                        <!-- Messages will be added here -->
                    </div>
                    <div class="chatbot-input">
                        <div class="input-group">
                            <input type="text" id="chatbot-input" placeholder="Nhập tin nhắn của bạn..." maxlength="500">
                            <button class="send-btn" id="send-btn">Gửi</button>
                        </div>
                    </div>
                </div>
            </div>
        `;
        document.body.insertAdjacentHTML('beforeend', chatbotHTML);
        console.log('Chatbot HTML added to page');
    }

    bindEvents() {
        const toggle = document.getElementById('chatbot-toggle');
        const close = document.getElementById('chatbot-close');
        const input = document.getElementById('chatbot-input');
        const sendBtn = document.getElementById('send-btn');

        toggle.addEventListener('click', () => this.toggleChat());
        close.addEventListener('click', () => this.closeChat());
        sendBtn.addEventListener('click', () => this.sendMessage());
        
        input.addEventListener('keypress', (e) => {
            if (e.key === 'Enter' && !e.shiftKey) {
                e.preventDefault();
                this.sendMessage();
            }
        });

        // Prevent chatbot from closing when clicking inside
        document.getElementById('chatbot-window').addEventListener('click', (e) => {
            e.stopPropagation();
        });
    }

    toggleChat() {
        const window = document.getElementById('chatbot-window');
        this.isOpen = !this.isOpen;
        
        if (this.isOpen) {
            window.style.display = 'flex';
            document.getElementById('chatbot-input').focus();
        } else {
            window.style.display = 'none';
        }
    }

    closeChat() {
        document.getElementById('chatbot-window').style.display = 'none';
        this.isOpen = false;
    }

    addWelcomeMessage() {
        const welcomeMessage = `
            Xin chào! Tôi là trợ lý ảo của Dunhuth Resort. 
            Tôi có thể giúp bạn:
            
            🏨 Thông tin về phòng và dịch vụ
            📅 Tư vấn đặt phòng
            🍽️ Thông tin nhà hàng và ẩm thực
            🎯 Các hoạt động và tour du lịch
            📍 Thông tin về khu vực xung quanh
            
            Bạn có câu hỏi gì không?
        `;
        this.addMessage(welcomeMessage, 'bot');
    }

    async sendMessage() {
        const input = document.getElementById('chatbot-input');
        const message = input.value.trim();
        
        if (!message) return;

        // Add user message
        this.addMessage(message, 'user');
        input.value = '';

        // Show typing indicator
        this.showTyping();

        try {
            // Get bot response
            const response = await this.getBotResponse(message);
            this.hideTyping();
            this.addMessage(response, 'bot');
        } catch (error) {
            this.hideTyping();
            this.addMessage('Xin lỗi, tôi đang gặp sự cố kỹ thuật. Vui lòng thử lại sau.', 'bot');
            console.error('Chatbot error:', error);
        }
    }

    addMessage(message, sender) {
        const messagesContainer = document.getElementById('chatbot-messages');
        const messageElement = document.createElement('div');
        messageElement.className = `message ${sender}`;
        
        const avatar = sender === 'bot' ? 'D' : 'U';
        const avatarClass = sender === 'bot' ? 'message-avatar' : 'message-avatar user-avatar';
        
        messageElement.innerHTML = `
            ${sender === 'bot' ? `<div class="${avatarClass}">${avatar}</div>` : ''}
            <div class="message-content">${this.formatMessage(message)}</div>
            ${sender === 'user' ? `<div class="${avatarClass}">${avatar}</div>` : ''}
        `;
        
        messagesContainer.appendChild(messageElement);
        messagesContainer.scrollTop = messagesContainer.scrollHeight;
    }

    formatMessage(message) {
        // Convert line breaks to HTML
        return message.replace(/\n/g, '<br>');
    }

    showTyping() {
        const messagesContainer = document.getElementById('chatbot-messages');
        const typingElement = document.createElement('div');
        typingElement.className = 'message bot';
        typingElement.id = 'typing-indicator';
        
        typingElement.innerHTML = `
            <div class="message-avatar">D</div>
            <div class="typing-indicator">
                <div class="typing-dots">
                    <div class="typing-dot"></div>
                    <div class="typing-dot"></div>
                    <div class="typing-dot"></div>
                </div>
            </div>
        `;
        
        messagesContainer.appendChild(typingElement);
        messagesContainer.scrollTop = messagesContainer.scrollHeight;
    }

    hideTyping() {
        const typingElement = document.getElementById('typing-indicator');
        if (typingElement) {
            typingElement.remove();
        }
    }

    async getBotResponse(userMessage) {
        // Nếu chưa có API key, trả về response mặc định
        if (!this.apiKey || this.apiKey === 'YOUR_GEMINI_API_KEY') {
            return this.getDefaultResponse(userMessage);
        }

        const prompt = this.createPrompt(userMessage);
        
        const requestBody = {
            contents: [{
                parts: [{
                    text: prompt
                }]
            }],
            generationConfig: {
                temperature: 0.7,
                topK: 1,
                topP: 1,
                maxOutputTokens: 2048,
            }
        };

        try {
            const response = await fetch(`${this.apiUrl}?key=${this.apiKey}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(requestBody)
            });

            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const data = await response.json();
            
            if (data.candidates && data.candidates[0] && data.candidates[0].content) {
                return data.candidates[0].content.parts[0].text;
            } else {
                return this.getDefaultResponse(userMessage);
            }
        } catch (error) {
            console.error('API Error:', error);
            return this.getDefaultResponse(userMessage);
        }
    }

    createPrompt(userMessage) {
        return `Bạn là trợ lý ảo của Dunhuth Resort, một khu nghỉ dưỡng cao cấp tại Việt Nam. 
        Hãy trả lời câu hỏi sau một cách thân thiện, chuyên nghiệp và hữu ích.
        
        Thông tin về resort:
        - Tên: Dunhuth Resort
        - Địa chỉ: 300 Nguyen Van Cu, Vinh, Nghe An
        - Điện thoại: +898 649 747
        - Email: dungnanoboy@dunduth.com
        - Các loại phòng: Standard Room, Deluxe Room, Family Room, Bungalow, Suite, Presidential Suite, Villa, Pool Villa Room, Luxury Ocean View Suite
        - Dịch vụ: Nhà hàng, Spa, Hồ bơi, Gym, Tour du lịch
        - Giá phòng từ $100-$1000/đêm tùy loại phòng
        
        Câu hỏi của khách: ${userMessage}
        
        Hãy trả lời ngắn gọn, rõ ràng và hữu ích (không quá 200 từ):`;
    }

    getDefaultResponse(userMessage) {
        const lowerMessage = userMessage.toLowerCase();
        
        // Phòng và giá cả
        if (lowerMessage.includes('phòng') || lowerMessage.includes('room')) {
            return `🏨 Dunhuth Resort có 9 loại phòng khác nhau:
            
            • Standard Room: $100/đêm (2 người)
            • Deluxe Room: $150/đêm (2 người) 
            • Family Room: $200/đêm (4 người)
            • Bungalow: $250/đêm (2 người)
            • Suite: $300/đêm (4 người)
            • Presidential Suite: $500/đêm (6 người)
            • Villa: $888/đêm (8 người)
            • Pool Villa Room: $1000/đêm (2 người)
            • Luxury Ocean View Suite: $169/đêm (4 người)
            
            Tất cả phòng đều có đầy đủ tiện nghi hiện đại!`;
        }
        
        // Đặt phòng
        if (lowerMessage.includes('đặt') || lowerMessage.includes('book')) {
            return `📅 Để đặt phòng, bạn có thể:
            
            • Sử dụng form "Book A Room" trên website
            • Gọi điện: +898 649 747
            • Email: dungnanoboy@dunduth.com
            • Hoặc truy cập mục "My Booking" để theo dõi đặt phòng
            
            Chúng tôi có hỗ trợ mã giảm giá và thanh toán linh hoạt!`;
        }
        
        // Địa chỉ và liên hệ
        if (lowerMessage.includes('địa chỉ') || lowerMessage.includes('liên hệ') || lowerMessage.includes('contact')) {
            return `📍 Thông tin liên hệ Dunhuth Resort:
            
            • Địa chỉ: 300 Nguyen Van Cu, Vinh, Nghe An
            • Điện thoại: +898 649 747
            • Email: dungnanoboy@dunduth.com
            • Website: www.dunhuthresort.com
            
            Chúng tôi luôn sẵn sàng phục vụ bạn 24/7!`;
        }
        
        // Dịch vụ
        if (lowerMessage.includes('dịch vụ') || lowerMessage.includes('service')) {
            return `🎯 Dunhuth Resort cung cấp đầy đủ dịch vụ:
            
            • 🍽️ Nhà hàng cao cấp
            • 💆‍♀️ Spa thư giãn
            • 🏊‍♂️ Hồ bơi ngoài trời
            • 💪 Phòng gym hiện đại
            • 🚗 Tour du lịch
            • 🎮 Khu vui chơi giải trí
            • 🏖️ Bãi biển riêng
            
            Mọi dịch vụ đều được thiết kế để mang lại trải nghiệm tốt nhất!`;
        }
        
        // Mặc định
        return `Cảm ơn bạn đã quan tâm đến Dunhuth Resort! 
        
        Tôi có thể giúp bạn về:
        • Thông tin phòng và giá cả
        • Hướng dẫn đặt phòng
        • Dịch vụ của resort
        • Thông tin liên hệ
        
        Bạn có câu hỏi cụ thể nào không?`;
    }
}

// Initialize chatbot when page loads
document.addEventListener('DOMContentLoaded', function() {
    console.log('DOM loaded, initializing chatbot...');
    // Wait a bit more to ensure all libraries are loaded
    setTimeout(function() {
        try {
            new DunhuthChatbot();
        } catch (error) {
            console.error('Error initializing chatbot:', error);
        }
    }, 1000);
});

// Fallback initialization
window.addEventListener('load', function() {
    // Check if chatbot already exists
    if (!document.getElementById('chatbot-toggle')) {
        console.log('Fallback: initializing chatbot...');
        try {
            new DunhuthChatbot();
        } catch (error) {
            console.error('Fallback error initializing chatbot:', error);
        }
    }
});
