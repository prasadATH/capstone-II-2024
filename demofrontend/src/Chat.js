import React, { useState } from 'react';
import { v4 as uuidv4 } from 'uuid';
import Message from './Message';
import MessageInput from './MessageInput.js';
import './chat.css';

const Chat = () => {
  const [messages, setMessages] = useState([]);

  const addMessage = (text, image) => {
    const newMessage = {
      id: uuidv4(),
      text,
      image,
      timestamp: new Date(),
      user: 'User',
    };
    setMessages([...messages, newMessage]);
  };
  
  
  return (
    <section className="section-header" id='blog' style={{marginTop:'30px'}}>
         <h2>Blog</h2>
         <p>Share your adventures, gain insights from others, and plan your next educational journey.</p>
    <div className="chat-window">
      <div className="messages">
        {messages.map(message => (
          <Message key={message.id} message={message} />
        ))}
      </div>
      <MessageInput addMessage={addMessage} />
    </div>
    </section>
  );
};

export default Chat;
