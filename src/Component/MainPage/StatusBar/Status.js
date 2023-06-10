import React, { Component } from 'react';
import "./StatusBar.css";
import {Paper} from '@material-ui/core';


class Status extends Component {
    constructor(props) {
        super(props);
        this.state = {  }
    }
    
    render() { 
        return ( 
            <div>
                <Paper className="statusbar_status" >
                <div className='statusbar_img'>
                    <img className='img' src={this.props.image}/>
                </div>
            
                <div className='statusbar_text'>
                    <div className='text' >{this.props.text}</div> 
                </div>
                </Paper>
            </div>
         );
    }
}
 
export default Status;