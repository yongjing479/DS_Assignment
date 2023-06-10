import React, { Component } from 'react';
import "./PostContainer.css";
import Post from "./Post";
import post from "../../../images/post.jpeg";
import profilePic from "../../../images/profile_pic.png";
import aurora from "../../../images/aurora.jpeg";
import user1 from "../../../images/user1.jpeg";
import user2 from "../../../images/dp3.png";



class PostContainer extends Component {
    constructor(props) {
        super(props);
    }
    state = { 
        data:[]
     }
     getData=()=>{
        let json=[
            {
                "post_ID": 1,
                "user_id": 12345678,
                "user_img": profilePic,
                "user_name" : "Jackson",
                "description": "Loved this wllpaper...",
                "post_img": post,
                "like":"25"
            },
            {
                "post_ID": 2,
                "user_id": 12345678,
                "user_img": user1,
                "user_name" : "Andy",
                "description": "Beautiful Aurora in Iceland",
                "post_img": aurora,
                "like":"10"
            },
            {
                "post_ID": 2,
                "user_id": 12345678,
                "user_img": user2,
                "user_name" : "Bendy",
                "description": "Busy week is coming soon",
                "post_img": "",
                "like":"10"
            }
        ]
        this.setState({data : json});
     }
     componentDidMount(){
        this.getData();
     }
    render() { 
        return ( 
            <div>
                {
                    this.state.data.map((item)=>(
                        <Post object={item}/>
                    ))
                }
                
                
            </div> 
        );
    }
}
 
export default PostContainer;