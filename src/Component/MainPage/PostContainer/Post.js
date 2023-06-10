import React, { Component } from 'react';
import "./PostContainer.css";
import {Paper} from '@material-ui/core';
import profilePic from "../../../images/profile_pic.png";
import post from "../../../images/post.jpeg";
import like from "../../../images/like.png";
import likebutton from "../../../images/likebutton.png";
import comment from "../../../images/comment.png";
import share from "../../../images/share.png";

class Post extends Component {
    constructor(props) {
        super(props);
    }
    state = {  }
    isImageAvailable=(data)=>{
        return data==""?false:true;
    }
    render() { 
        return ( 
            <div>
                <Paper className="post_container">
                    {/* header */}
                    <div className='post_header'>
                        <div className='post_header_img'>
                            <img className='post_img' src={this.props.object.user_img} />
                        </div> 
                        <div className='post_header_text'>
                            {this.props.object.user_name}
                        </div>
                    </div>
                    {/* description */}
                    <div className='post_description'>
                        {this.props.object.description}
                    </div>
                    {/* image */}
                    <div className='post_image'>
                        {
                            this.isImageAvailable() ?<img src={this.props.object.post_img} width="600px"/> : <span></span>
                        }
                        
                    </div>
                    {/* like count */}
                    <div className='post_likeCountContainer'>
                        <div className='post_like'>
                            <img className="post_likeimg" src={like} />
                        </div>
                        <div className="post_likecount">
                            {this.props.object.like}
                        </div>
                    </div>
                    {/* like share box */}
                    <div className="post_likeShare">
                        <div className='post_tab'>
                            <div className='post_tabfirst'>
                                <img className="post_tabimg" src={likebutton} />
                            </div>
                            <div className='post_tabtext'>
                                Like
                            </div>
                        </div>

                        <div className='post_tab'>
                            <div className='post_tabfirst'>
                                <img className="post_tabimg" src={comment} />
                            </div>
                            <div className='post_tabtext'>
                                Comment
                            </div>
                        </div>

                        <div className='post_tab'>
                            <div className='post_tabfirst'>
                                <img className="post_tabimg" src={share} />
                            </div>
                            <div className='post_tabtext'>
                                Share
                            </div>
                        </div>
                    </div>
                    {/* comment box */}
                    <div className="upload_comment">
                        <div className='post_top'>
                            <img className='post_commentimg' src={profilePic} />
                        </div>
                        <div>
                            <input className="post_box" placeholder="What's on your mind ?" type="text" />
                        </div>
                    </div>
                </Paper>    
            </div>
         );
    }
}
 
export default Post;