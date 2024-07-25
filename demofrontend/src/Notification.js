import React, { useState } from 'react';
import './Notification.css'; // Import your CSS file for notification styles

const Notification = ({ message, onClose }) => {
    const [isVisible, setIsVisible] = useState(true);

    const handleClose = () => {
        setIsVisible(false);
        onClose(); // Call the onClose function to handle any necessary actions
    };

    return (
        <>
            {isVisible && (
                <div className="notification">
                    <div className="notification-content">
                        <span>{message}</span>
                        <button onClick={handleClose}>Close</button>
                    </div>
                </div>
            )}
        </>
    );
};

export default Notification;
