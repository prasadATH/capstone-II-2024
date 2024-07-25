import React, { useState } from 'react';
import { styled, alpha } from '@mui/material/styles';
import InputBase from '@mui/material/InputBase';



  const showAlert = () => {
    window.alert('This is an alert!');
  };
  
export default function MainHeader() {


  return (
   /*  <!--works start --> */
    <section id="works" className="works">
        <div className="container">
            <div className="section-header">
                <h2>how it works</h2>
                <p>Learn More about how our website works</p>
            </div>{/* <!--/.section-header--> */}
            <div className="works-content">
                <div className="row">
                    <div className="col-md-4 col-sm-6">
                        <div className="single-how-works">
                            <div className="single-how-works-icon">
                                <i className="flaticon-lightbulb-idea"></i>
                            </div>
                            <h2><a href="#">Choose <span> what to</span> Learn</a></h2>
                            <p>
                                Lorem ipsum dolor sit amet, consecte adipisicing elit, sed do eiusmod tempor incididunt ut laboremagna aliqua. 
                            </p>
                            <button className="welcome-hero-btn how-work-btn" onclick="window.location.href='#'">
                                read more
                            </button>
                        </div>
                    </div>
                    <div className="col-md-4 col-sm-6">
                        <div className="single-how-works">
                            <div className="single-how-works-icon">
                                <i className="flaticon-networking"></i>
                            </div>
                            <h2><a href="#">Find <span> places to travel</span></a></h2>
                            <p>
                                Lorem ipsum dolor sit amet, consecte adipisicing elit, sed do eiusmod tempor incididunt ut laboremagna aliqua. 
                            </p>
                            <button className="welcome-hero-btn how-work-btn" onclick="window.location.href='#'">
                                read more
                            </button>
                        </div>
                    </div>
                    <div className="col-md-4 col-sm-6">
                        <div className="single-how-works">
                            <div className="single-how-works-icon">
                                <i className="flaticon-location-on-road"></i>
                            </div>
                            <h2><a href="#">explore <span> amazing</span> places while learning</a></h2>
                            <p>
                                Lorem ipsum dolor sit amet, consecte adipisicing elit, seds. 
                            </p>
                            <button className="welcome-hero-btn how-work-btn" onclick="window.location.href='#'">
                                read more
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>{/* <!--/.container--> */}
    
    </section>/* <!--/.works--> */
  /*   <!--works end --> */

  );
}
