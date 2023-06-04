import React from 'react';
import './SignUp.css';
import SignUpModal from './SignUpModal';
// import Popup from '../SignUp/SignUpModal';

function SignUp() {
  // const [trigger, setTrigger] = useState(false);
  return (
    <div>
      <SignUpModal />
      {/* <button className="signin-btn" onClick={() => setTrigger(true)}>
        
      </button> */}
      {/* <Popup trigger={trigger} setTrigger={setTrigger} /> */}
    </div>
  );
}

export default SignUp;
