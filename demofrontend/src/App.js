import './App.css';
/*import DemoAppBar from './appbar'
*/

import Home from './Home';
import Guide from './GuideSection';
import Login from './Login';
import $ from 'jquery';
import Services from './Services';
import Logo from './assets/logo/favicon.png';
import './assets/css/font-awesome.min.css';
import './assets/css/linearicons.css';
import './assets/css/animate.css';
import './assets/css/flaticon.css';
import './assets/css/slick.css';
import './assets/css/slick-theme.css';
import './assets/css/bootstrapMin.css';
import './assets/css/bootsnav.css';

import './assets/css/style.css';
import './assets/css/responsive.css';
import NavBar from './NavBar';
import Reviews from './Reviews';
import Chat from './Chat';
import Bot from './Chatbot';
import Iternary from './Iternary';
import ContactForm from './ContactForm';
import Statistics from './Statistics';
import MapComponent from './Map';

import img from './assets/images/welcome-hero/banner.jpg';


function App() {
  const origin = 'Ja-Ela, Sri Lanka'; // Origin location name
  const destination = 'Colombo, Sri Lanka'; // Destination location name
  const stops = ['Nittambuwa, Sri Lanka', 'Kegalle, Sri Lanka','Nuwara Eliya, Sri Lanka', 'Ratnapura, Sri Lanka' ]; // Add any number of stops



  return (
    <div className="App">
  
<Home/>

<Guide/>
<Services/>
<Chat/>
<Reviews/>
<Bot/>
<MapComponent origin={origin} destination={destination} stops={stops} />
<Statistics/>
<ContactForm/>


    </div>
    
    
  );
}

export default App;
