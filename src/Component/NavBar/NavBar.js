// import React, { Component } from 'react';
// import "./NavBar.css";
// import Grid from '@mui/material/Grid';
// import logo from "../../images/sircle.png";
// import home from "../../images/home.svg";
// import page from "../../images/pages.svg";
// import watch from "../../images/watch.svg";
// import market from "../../images/market.svg";
// import group from "../../images/groups.svg";
// import profilePic from "../../images/profile_pic.png";
// import comment from "../../images/comment2.png"
// import bell from "../../images/bell2.png"

// import { Avatar } from '@mui/material';


// class NavBar extends Component {
//     constructor(props) {
//         super(props);
//     }
//     state = {  }
//     render() { 
//         return ( 
//             <div>
//                 <Grid container className="navbar_main">
//                     <Grid item xs={3}>
//                         <div className="navbar_leftbar">
//                             <img className="navbar_logo" src= {logo} width="55px"/>
//                             <input className="navbar_search" type="text" placeholder='Search Sircle' />
//                         </div>
//                     </Grid>
//                     <Grid item xs={6}>
//                         <div className="navbar_container">
//                             <div className="navbar_tabs active">
//                                 <img src = {home} height="35px" width="35px"/>
//                             </div>
//                             <div className="navbar_tabs" >    
//                                 <img src = {page} height="35px" width="35px"/>
//                             </div>
//                             <div className="navbar_tabs">
//                                 <img src = {watch} height="35px" width="35px"/>
//                             </div>
//                             <div className="navbar_tabs">
//                                 <img src = {market} height="35px" width="35px"/>
//                             </div>
//                             <div className="navbar_tabs">
//                                 <img src = {group} height="35px" width="35px"/>
//                             </div>    
//                         </div>
//                     </Grid>
//                     <Grid item xs={3}>
//                         <div className="navbar_right">
//                             <div className="navbar_righttabs">
//                                 <img  src = {comment} height="35px" width="35px"/>
//                             </div>
//                             <div className="navbar_righttabs">
//                                 <img className="navbar_bell" src = {bell} height="30px" width="30px"/>
//                             </div>
//                             <div className="nav_righttabs">
//                                 <img className="navbar_righting" src={profilePic} />
//                                 <div class = "triangle" ></div>
//                             </div>

//                         </div>
//                     </Grid>
//                 </Grid>
//             </div>
//          );
//     }
// }
 
// export default NavBar;


import React from 'react';
import "./NavBar.css";
import Grid from '@mui/material/Grid';
import logo from "../../images/sircle.png";
import home from "../../images/home.svg";
import page from "../../images/pages.svg";
import watch from "../../images/watch.svg";
import market from "../../images/market.svg";
import group from "../../images/groups.svg";
import profilePic from "../../images/profile_pic.png";
import comment from "../../images/comment2.png"
import bell from "../../images/bell2.png"

// import { Avatar } from '@mui/material';

const NavBar = () => {
  return (
    <div>
      <Grid container className="navbar_main">
        <Grid item xs={3}>
          <div className="navbar_leftbar">
            <img className="navbar_logo" src={logo} width="55px" />
            <input className="navbar_search" type="text" placeholder='Search Sircle' />
          </div>
        </Grid>
        <Grid item xs={6}>
          <div className="navbar_container">
            <div className="navbar_tabs active">
              <img src={home} height="35px" width="35px" />
            </div>
            <div className="navbar_tabs" >
              <img src={page} height="35px" width="35px" />
            </div>
            <div className="navbar_tabs">
              <img src={watch} height="35px" width="35px" />
            </div>
            <div className="navbar_tabs">
              <img src={market} height="35px" width="35px" />
            </div>
            <div className="navbar_tabs">
              <img src={group} height="35px" width="35px" />
            </div>
          </div>
        </Grid>
        <Grid item xs={3}>
          <div className="navbar_right">
            <div className="navbar_righttabs">
              <img src={comment} height="35px" width="35px" />
            </div>
            <div className="navbar_righttabs">
              <img className="navbar_bell" src={bell} height="30px" width="30px" />
            </div>
            <div className="nav_righttabs">
              <img className="navbar_righting" src={profilePic} />
              <div className="triangle"></div>
            </div>

          </div>
        </Grid>
      </Grid>
    </div>
  );
}

export default NavBar;
