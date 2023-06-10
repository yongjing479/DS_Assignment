import React, { Component } from 'react';
import "./UploadSection.css";
import { Paper} from '@material-ui/core';
import { Avatar } from '@mui/material';
import profilePic from "../../../images/profile_pic.png";
import live from "../../../images/video.png";
import image from "../../../images/image.png";
import feeling from "../../../images/feelings.png";


class UploadSection extends Component {
    constructor(props) {
        super(props);
    }
    state = {  }
    render() { 
        return ( 
            <div>
                <Paper className="upload_container" >
                    <div className="upload_top">
                        <div>
                            <img className='upload_img' src={profilePic} />
                        </div>
                        <div>
                            <input className="upload_box" placeholder="What's on your mind ?" type="text" />
                        </div>
                    </div>
                    <div className="upload_bottom">
                        <div className='upload_tabs'>
                            <img src={live} width="35px"/>
                            <div className='upload_text'>Live Video</div>
                        </div>
                        <div className='upload_tabs'>
                            <img src={image} width="35px"/>
                            <div className='upload_text'>Photo/Video</div>
                        </div>
                        <div className='upload_tabs'>
                            <img src={feeling} width="35px"/>
                            <div className='upload_text'>Feeling/Activity</div>
                        </div>
                    </div>
                </Paper>
            </div>
         );
    }
}
 
export default UploadSection;