import React, { useState } from 'react';
import './chat.css';
import AttachFileIcon from '@mui/icons-material/AttachFile';

const MessageInput = ({ addMessage }) => {
  const [text, setText] = useState('');
  const [image, setImage] = useState(null);

  const handleSend = () => {
    if (text || image) {
      addMessage(text, image);
      setText('');
      setImage(null);
    }
  };

  const handleImageChange = (e) => {
    const file = e.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setImage(reader.result);
      };
      reader.readAsDataURL(file);
    }
  };

  return (
    <div className="message-input">
      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="Type a message"
      />
      <label htmlFor="file-input" className="attachment-label">
        <AttachFileIcon />
      </label>
      <input
        id="file-input"
        type="file"
        accept="image/*"
        onChange={handleImageChange}
        style={{ display: 'none' }}
      />
      {image && (
        <div className="thumbnail-container">
          <img src={image} alt="thumbnail" className="thumbnail" />
          <button className="remove-thumbnail" onClick={() => setImage(null)}>X</button>
       
        </div>
      )}
       <button onClick={handleSend}>Send</button>
    </div>
  );
};

export default MessageInput;
