import React from 'react';
import { motion } from 'framer-motion';
import './chat.css';

const Message = ({ message }) => {
  return (
    <motion.div
      className="message"
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      transition={{ duration: 0.5 }}
    >
      <div className="message-content">
        {message.image && <img src={message.image} alt="message" />}
        <p>{message.text}</p>
      </div>
      <div className="message-meta">
      <span>{message.timestamp.toLocaleTimeString()}</span>
        <span>{message.user}</span>
      
      </div>
    </motion.div>
  );
};

export default Message;
