import React, { Component } from 'react';
import Status from './Status';
import "./StatusBar.css";
import ImageLayouts from '../ImageLayouts';
import profilePic from "../../../images/profile_pic.png";
import covid from "../../../images/covid.png";
import groups from "../../../images/groups.png";
import memories from "../../../images/memories.png";
import recent from "../../../images/most recent icon.png";
import saved from "../../../images/saved posts icon.png";
import messenger from "../../../images/messengerkids.png";
import UmConffesions from "../../../images/aurora.jpeg";

class StatusBar extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            data:[]
         } 
    }

    getData=() => {
        let jsondata =[
            {
                "image":UmConffesions,
                "text":"Andy",
            },
            {
                "image":covid,
                "text":"Bendy",
            },
            {
                "image":groups,
                "text":"Candy",
            },
            {
                "image":memories,
                "text":"Diskson",
            },
            {
                "image":recent,
                "text":"Elna",
            },
            {
                "image":saved,
                "text":"Fatri",
            },
            {
                "image":messenger,
                "text":"Gatha",
            },
            {
                "image":messenger,
                "text":"Gatha",
            },
            {
                "image":messenger,
                "text":"Gatha",
            }
        ];
        this.setState({data : jsondata});
    }

    componentDidMount(){
        this.getData();
    }

    
    render() { 
        return ( 
            <div className="statusbar_container">
                {
                    this.state.data.map( (item) =>(
                    <Status image={item.image} text={item.text} />
                    ))
                } 
            </div> 
        );
    }
}
 
export default StatusBar;