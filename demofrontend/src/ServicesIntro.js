import React, { useState } from 'react';
import { styled, alpha } from '@mui/material/styles';
import bot from './assets/images/bot-icon.png';
import InputBase from '@mui/material/InputBase';

const Search = styled('div')(({ theme }) => ({
  position: 'relative',
  borderRadius: theme.shape.borderRadius,
  backgroundColor: alpha(theme.palette.common.white, 0.15),
  '&:hover': {
    backgroundColor: alpha(theme.palette.common.white, 0.25),
  },
  marginRight: theme.spacing(2),
  marginLeft: 0,
  width: '100%',
  [theme.breakpoints.up('sm')]: {
    marginLeft: theme.spacing(3),
    width: 'auto',
  },
}));

const SearchIconWrapper = styled('div')(({ theme }) => ({
  padding: theme.spacing(0, 2),
  height: '100%',
  position: 'absolute',
  pointerEvents: 'none',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
}));

const StyledInputBase = styled(InputBase)(({ theme }) => ({
  color: 'inherit',
  '& .MuiInputBase-input': {
    padding: theme.spacing(1, 1, 1, 0),
    paddingLeft: `calc(1em + ${theme.spacing(4)})`,
    transition: theme.transitions.create('width'),
    width: '100%',
    [theme.breakpoints.up('md')]: {
      width: '20ch',
    },
  },
}));

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
