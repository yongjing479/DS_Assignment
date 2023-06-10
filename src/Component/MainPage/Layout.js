// import React, { Component } from 'react';
// import "./MainPage.css";
// import { Grid } from '@mui/material';
// import LeftSide from './LeftSidePanel/LeftSide';
// import StatusBar from './StatusBar/StatusBar';
// import UploadSection from './UploadSection/UploadSection';
// import PostContainer from './PostContainer/PostContainer';
// import RightSlide from './RightSlidePanel/RightSlide';

// class Layout extends Component {
//     constructor(props) {
//         super(props);
//         this.state = {  }
//     }
    
//     render() { 
//         return ( 
//             <div className="mainpage_container">
//                 <Grid container>
//                     <Grid item xs={3}>
//                         <LeftSide />
//                     </Grid>
//                     <Grid item xs={6} className='middleContainer'>
//                         <StatusBar />
//                         <UploadSection />
//                         <PostContainer />
//                     </Grid>
//                     <Grid item xs={3}>
//                         <RightSlide />
//                     </Grid>
//                 </Grid>    
//             </div>
//          );
//     }
// }

 
// export default Layout;

import React from 'react';
import "./MainPage.css";
import { Grid } from '@mui/material';
import LeftSide from './LeftSidePanel/LeftSide';
import StatusBar from './StatusBar/StatusBar';
import UploadSection from './UploadSection/UploadSection';
import PostContainer from './PostContainer/PostContainer';
import RightSlide from './RightSlidePanel/RightSlide';

const Layout = () => {
  return (
    <div className="mainpage_container">
      <Grid container>
        <Grid item xs={3}>
          <LeftSide />
        </Grid>
        <Grid item xs={6} className='middleContainer'>
          <StatusBar />
          <UploadSection />
          <PostContainer />
        </Grid>
        <Grid item xs={3}>
          <RightSlide />
        </Grid>
      </Grid>
    </div>
  );
}

export default Layout;
