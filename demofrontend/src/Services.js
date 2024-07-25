import * as React from 'react';
import { useState } from 'react';
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';

import { grey } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';

import {coursesData} from './data';
import BiSearch from '@mui/icons-material/Search';
import Button from '@mui/material/Button';
import { Style } from '@mui/icons-material';
import './services.css';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
}));

export default function RecipeReviewCard() {
  const [expanded, setExpanded] = React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };
  const [search, setSearch] = useState ('');
  function sectionHighlight(){
    document.getElementById('menu-explore').style.color = '#ff545a';
  }

  function remSectionHighlight(){
    document.getElementById('menu-explore').style.color = '#859098';
  }

  return (
    <section id="explore" style={{marginBottom:'45px'}} >
    <div style={{marginBottom:'100px', width: '90%', margin:'auto'}}>
        <div className="course_wrapper section-header" >
        <h2>Explore</h2>
        <p>Explore New place, food, culture around the world and many more</p>
          <div className="search_input">
            <BiSearch className='search_icon'/>
            <input type="text" id="searchInput" placeholder='Search Attractions/ Hotel/ Courses/ Travel Plans' onChange={(event) => {
              setSearch(event.target.value)
            }}/>
          </div>
       </div>
          <div className="course_container" style={{ height: '800px',width:'80%',margin:'auto', overflowY: 'auto',scrollbarWidth:'none'}}>
            {coursesData.filter((val) => {
              if(search == ""){
                return val;
              } else if((val.name.toLowerCase().includes(search.toLocaleLowerCase())) ||(val.standard.toLowerCase().includes(search.toLocaleLowerCase()))){
                return val;
              }
            })
            .map(({image, name, price, standard})=> {

  return (
    
    <Card className = "cardElement" sx={{ maxWidth: 345 }} style={{border:"2px solid ", hover:{boxShadow:"5px 5px grey"}} }
       >
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
            R
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        
        title={
            <Typography variant="h6" sx={{ fontSize: '1.5rem' }}>
              {name}
            </Typography>
          }
          subheader={
            <Typography variant="h6" sx={{ fontSize: '1.5rem' }}>
              {price}
            </Typography>
          }
        
       
      />
      <CardMedia
        component="img"
        height="194"
        image={image}
        alt="img"
        boxShadow
      />
      <CardContent>
        <Typography variant="body2" color="text.secondary">
          {standard}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="add to favorites">
          <FavoriteIcon />
        </IconButton>
        <IconButton aria-label="share">
          <ShareIcon />
        </IconButton>
        <Button variant="contained" className = "bookBut" color="success">
        Book
      </Button>
        <ExpandMore
          expand={expanded}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </ExpandMore>
      </CardActions>
     
    </Card>
  );


              })
             }
          </div>
      </div>
      </section>



  )
}


