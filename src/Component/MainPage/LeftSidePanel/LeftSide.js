import React, { Component } from 'react';
import "./LeftSide.css";
import ImageLayouts from '../ImageLayouts';
import profilePic from "../../../images/profile_pic.png";
import covid from "../../../images/covid.png";
import groups from "../../../images/groups.png";
import memories from "../../../images/memories.png";
import recent from "../../../images/most recent icon.png";
import saved from "../../../images/saved posts icon.png";
import messenger from "../../../images/messengerkids.png";
import UmConffesions from "../../../images/UMConfessions.png";
import gdsc from "../../../images/gdsc.png";
import RecentLayout from './RecentLayout';

// import covid from 


class LeftSide extends Component {
    constructor(props) {
        super(props);
        this.state ={ 
            data:[],
            recentData:[]
        } 
    }

    getData=() => {
        let jsondata =[
            {
                "image":profilePic,
                "text":"Jackson"
            },
            {
                "image":covid,
                "text":"COVID-19 Information Centre"
            },
            {
                "image":groups,
                "text":"Friends"
            },
            {
                "image":memories,
                "text":"Memories"
            },
            {
                "image":recent,
                "text":"Most recent"
            },
            {
                "image":saved,
                "text":"Saved"
            },
            {
                "image":messenger,
                "text":"Messenger Kids"
            }
        ];
        this.setState({data : jsondata});
    }

    getRecentData=() =>{
        let jsondata =[
            {
                "image":UmConffesions,
                "text":"UM Confessions 2.0"
            },
            {
                "image":gdsc,
                "text":"Developer Student Club UM"
            }
        ];
        this.setState({recentData : jsondata});
    }

    componentDidMount(){
        this.getData();
        this.getRecentData();
    }
    
    render() { 
        return ( 
        <div className="left_separation">
            <div>
               {
                    this.state.data.map( (item) =>(
                    <ImageLayouts image={item.image} text={item.text} />
                    ))
                } 
            </div>
            <div className='line_separation'></div>
            <div className="shortcut">Recent Shortcut</div> 
            <div className="image_container">
                {
                    this.state.recentData.map( (item) => (
                    <ImageLayouts  image={item.image} text={item.text} />
                    ))
                }

            </div>
            
        </div> 
        );
    }
}
 
export default LeftSide;