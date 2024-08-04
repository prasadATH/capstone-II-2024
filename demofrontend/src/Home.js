import React, { useState, useEffect } from 'react';


import University from './assets/images/university.png';
import Destination from './assets/images/destination.png';
import Hotel from './assets/images/hotel.png';
import Tour from './assets/images/tour.png';
import './home.css';
import './assets/css/bootstrapMin.css';
import MenuIcon from '@mui/icons-material/Menu';

import { motion } from 'framer-motion';
import { Link } from 'react-scroll';
import { Dropdown } from 'rsuite';



const showAlert = () => {
  window.alert('This is an alert!');
};



export default function MainHeader() {

  const items = ['Signup', 'Login', 'Settings'];
 
    const [isOpen, setIsOpen] = useState(false);
    const [selectedItem, setSelectedItem] = useState(null);
  
    const toggleDropdown = () => {
      setIsOpen(!isOpen);
    };
  
    const handleItemClick = (item) => {
      setSelectedItem(item);
      setIsOpen(false);

      if(item =='Signup')
      {
        openSignupModal();
      }else if(item =='Login')
      {
         openLoginModal();
      }else if(item =='Settings')
      {

      }
    };
  

  const [isLoginModalVisible, setLoginModalVisible] = useState(false);
  const [isSignupModalVisible, setSignupModalVisible] = useState(false);

  const [isVisible, setIsVisible] = useState(false);


  const openLoginModal = () => {
    setSignupModalVisible(false);
    setLoginModalVisible(true);
    setIsVisible(true);
  };

  const closeLoginModal = () => setLoginModalVisible(false);

  const openSignupModal = () => {
    setLoginModalVisible(false);
    setSignupModalVisible(true);
  };
  useEffect(() => {
    // Set visibility to true after component mounts to trigger the transition
    setLoginModalVisible(false);

  }, []);
  const closeSignupModal = () => setSignupModalVisible(false);
  const offset = -window.innerHeight * 0.25;

  const [name, setName] = useState();
  const [email, setEmail] = useState();
  const [country, setCountry] = useState();
  const [username, setUsername] = useState();
  const [password, setPassword] = useState();

  const [authenticated, setAuthenticated] = useState();


  const handleSignup = (e) => {
    e.preventDefault();
    const newTraveller = { name, country, email, username, password };
    console.log(newTraveller);

    fetch("http://localhost:8080/auth/signup", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newTraveller)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.text();  // assuming the server returns JSON
    })
    .then(data => {
        window.alert('Registration successful!');
        
        console.log("New Traveller added successfully", data);
        closeSignupModal();
        openLoginModal();
    })
    .catch(error => {
        window.alert('Registration failed!');
        console.error("Error adding new traveller:", error);
    });
}

const handleLogin = (e) => {
  e.preventDefault();
  console.log(username, password);

  const loginData = {
      username: username,
      password: password
  };

  fetch("http://localhost:8080/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(loginData)  // Correctly stringify the object as JSON
  })
  .then(response => {
      if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
      }
      return response.text();  // Parse the response body as JSON
  })
  .then(data => {
      if (data === 'Username or password is incorrect!') {  // Use 'data' instead of 'response.text'
          window.alert(data);  // Display the error message from the server
      } else {
          window.alert('Login Successful!');
          console.log("Login Successful", data);
          setAuthenticated(true);
          closeLoginModal();
          // Handle success: redirect or set logged-in state
      }
  })
  .catch(error => {
      window.alert('Login failed!');  // Display a generic error message
      console.error("Error logging in:", error);
  });
};




  return (
    <body>
      <div>





        <section className="top-area">

          <div className="header-area">
          <nav className="navbar navbar-default bootsnav navbar-sticky navbar-scrollspy" data-minus-value-desktop="70" data-minus-value-mobile="55" data-speed="1000" style={{width:'56%',height:'85px',borderRadius: '60px', padding: '0',marginTop: '10px',marginLeft:'22%', opacity:'0.9', backgroundColor:'#E6E6FA'}} >
                      <div className="container" >
                        <div className="navbar-header">

                        <img src='../logo/logo.jpg' alt="clients" style={{ width: '79px', borderRadius: '60px', margin:'auto'}} />

                        </div>
                        <div className="collapse navbar-collapse menu-ui-design" id="navbar-menu" style={{ marginTop:'5px'}} >
               
                  <ul className="nav navbar-nav navbar-right menu" data-in="fadeInDown" data-out="fadeOutUp">

                    <li id='menu-home' className="scroll"> <Link to="home" smooth={true} duration={1500} offset={offset}>
                      Home <span className='menu-divider'>|</span>
                    </Link></li>

                    <li className="scroll" id='menu-works'> <Link to="works" smooth={true} duration={1500} offset={offset}>
                      About Us <span className='menu-divider'>|</span>
                    </Link></li>

                    <li className="scroll" id='menu-explore'>        <Link to="explore" smooth={true} duration={1500} offset={offset}>
                      Explore <span className='menu-divider'>|</span>
                    </Link></li>

                    <li className="scroll" id='menu-blog'>        <Link to="blog" smooth={true} duration={1500} offset={offset}>
                      Blog <span className='menu-divider'>|</span>
                    </Link></li>


                    <li className="scroll" id='menu-contact'>        <Link to="contact" smooth={true} duration={1500} offset={offset}>
                      Contact
                    </Link></li>

    <div className="dropdown">
      <button id="menu" onClick={toggleDropdown} style={{ marginTop: '11px'}}>
      <MenuIcon style={{ fontSize: 35, color: 'red' }} />
      </button>
      {isOpen && (
        <ul className="dropdown-menu">
          {items.map((item, index) => (
            <li
              key={index}
              className="dropdown-item"
              onClick={() => handleItemClick(item)}
            >
              {item}
            </li>
          ))}
        </ul>
      )}
    </div>
                  
                  </ul>
                  {authenticated && (
                  <p style={{ fontSize: '25px', float:'left', fontFamily: "Lucida Console", marginLeft:'10px'}}>Welcome! {username}<br/>Happy Exploring!</p>
                )}
                </div>
               
              </div>
           
            </nav>
          </div>
          <div className="clearfix"></div>
        </section>


        {isLoginModalVisible && (


          <motion.div
            initial={{
              opacity: 0
            }}
            animate={{
              opacity: 1,
              transition: {
                duration: 0.5
              }
            }}
            exit={{
              opacity: 0,

              transition: {
                duration: 0.5,
              },
            }}
            id="loginModal-login" class='loginForm' >
            <motion.div
              initial={{
                opacity: 0,
                y: -50,  // Start 50px above its initial position
              }}
              animate={{
                opacity: 1,
                y: 0,  // Move to its original position
                transition: {
                  duration: 0.5,  // Duration of the animation
                },
              }}
              exit={{
                opacity: 0,
                y: -50,  // Slide back up when exiting
                transition: {
                  duration: 0.5,
                },
              }}
              class='loginFormContent' style={{ margin: 'auto', width: '50%', background: 'cadetblue', color: 'black' }}>
              <span className="close-button" onClick={closeLoginModal}>&times;</span>
              <h2>Login</h2>

              <form >
                <label htmlFor="username">Username:</label>
                <input type="text" id="username" name="username" required
                  onChange={(e) => setUsername(e.target.value)} />

                <label htmlFor="password">Password:</label>
                <input type="password" id="password" name="password" required
                  onChange={(e) => setPassword(e.target.value)} />
                <button type="submit" onClick={handleLogin}>Submit</button>
                <a href="#">Not registered? <button type="button" onClick={openSignupModal}>Sign up</button></a>
              </form>

            </motion.div>
          </motion.div>

        )}


        {isSignupModalVisible && (

          <motion.div
            initial={{
              opacity: 0
            }}
            animate={{
              opacity: 1,
              transition: {
                duration: 0.5
              }
            }}
            exit={{
              opacity: 0,

              transition: {
                duration: 0.5,
              },
            }}
            id="loginModal-login" class='loginForm' >
            <motion.div
              initial={{
                opacity: 0,
                y: -50,  // Start 50px above its initial position
              }}
              animate={{
                opacity: 1,
                y: 0,  // Move to its original position
                transition: {
                  duration: 0.5,  // Duration of the animation
                },
              }}
              exit={{
                opacity: 0,
                y: -50,  // Slide back up when exiting
                transition: {
                  duration: 0.5,
                },
              }}
              class='loginFormContent' style={{ margin: 'auto', width: '50%', background: 'cadetblue', color: 'black' }}>

              <span className="close-button" onClick={closeSignupModal}>&times;</span>
              <h2>Sign up</h2>
              <form>
                <label htmlFor="name">Name:</label>
                <input type="text" id="name" name="name" required 
                onChange={(e) => setName(e.target.value)} />
                <label htmlFor="email">Email:</label>
                <input type="email" id="email" name="email" required 
                onChange={(e) => setEmail(e.target.value)} />
                <label htmlFor="country">Country:</label>
                <input type="text" id="country" name="country" required 
                onChange={(e) => setCountry(e.target.value)} />
                <label htmlFor="username">Username:</label>
                <input type="text" id="username" name="username" required 
                 onChange={(e) => setUsername(e.target.value)} />
                <label htmlFor="password">Password:</label>
                <input type="password" id="password" name="password" required 
                 onChange={(e) => setPassword(e.target.value)} />
                <button type="submit" onClick={handleSignup} >Submit</button>
                <a href="#">Already have an account? <button type="button" onClick={openLoginModal}>Log in</button></a>
              </form>
            </motion.div>
          </motion.div>

        )}

        <section id="home" className="welcome-hero">

          <div className="container">
            <div className="welcome-hero-txt">

              <h2>Best place to learn and explore <br /> Sri Lanka </h2>
              <p>
                Find Best Places to Travel, Learn, Stay and many more in just One click
              </p>
            </div>
            <div className="welcome-hero-serch-box">
              <div className="welcome-hero-form">
                <div className="single-welcome-hero-form">
                  <form action="index.html">
                    <input type="text" placeholder="Enter Attractions/ Hotel/ Courses/ Travel Plans" />
                  </form>
                </div>
              </div>
              <div className="welcome-hero-serch">
                <button className="welcome-hero-btn" onClick={() => window.location.href = '#'}>
                  search <i data-feather="search"></i>
                </button>
              </div>
            </div>
          </div>
        </section>
      </div>

      {/* <!--list-topics start -->  */}
      <section id="list-topics" class="list-topics">
        <div class="container">
          <div class="list-topics-content">
            <ul>
              <li>
                <div class="single-list-topics-content">

                  <img class="services-icon" src={University} alt="uni image" />

                  <h2><a href="#">Courses</a></h2>
                  <p>150 listings</p>
                </div>
              </li>
              <li>
                <div class="single-list-topics-content">
                  <img class="services-icon" src={Destination} alt="travel image" />
                  <h2><a href="#">Destinations</a></h2>
                  <p>214 listings</p>
                </div>
              </li>
              <li>
                <div class="single-list-topics-content">
                  <img class="services-icon" src={Hotel} alt="hotel image" />
                  <h2><a href="#">Hotels</a></h2>
                  <p>185 listings</p>
                </div>
              </li>
              <li>
                <div class="single-list-topics-content">
                  <img class="services-icon" src={Tour} alt="tour image" />
                  <h2><a href="#">Packages</a></h2>
                  <p>200 listings</p>
                </div>
              </li>

            </ul>
          </div>
        </div>{/* <!--/.container--> */}

      </section>{/* <!--/.list-topics--> */}
      {/* <!--list-topics end--> */}
    </body>
  );
}
