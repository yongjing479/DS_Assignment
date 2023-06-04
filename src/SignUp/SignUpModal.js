
import React, { useState } from 'react';
import { Button, Modal, Input } from 'antd';
import { EyeTwoTone, EyeInvisibleOutlined } from '@ant-design/icons';
import './SignUp.css';
import DOB from './DatePicker';
import Gender from './Gender';


const SignUpModal = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [activeInput, setActiveInput] = useState('');


  const showModal = () => {
    setIsModalOpen(true);
  };

  const handleOk = () => {
    setIsModalOpen(false);
  };

  const handleCancel = () => {
    setIsModalOpen(false);
  };

  const handleInputFocus = (inputName) => {
    setActiveInput(inputName);
  };
  
  return (
    <div className="signupbutton">     
      <Button       
        type="green-6"
        onClick={showModal}
        style={{
          color: 'white',
          fontWeight: 'bold',
          fontSize: '17px',
          width: '100%',
          height: '20px',
          marginBottom: '10px',
          alignItems: 'center',  
          background: 'transparent',
          border: 'none',
          transition: 'color 0.3s ease'    
          }}
          className="create-button"
      >
        Create New Account
      </Button>
      <Modal
        title="Sign Up"
        visible={isModalOpen}
        onOk={handleOk}
        onCancel={handleCancel}
        okButtonProps={{ type: 'primary' }}
        okText="Sign Up"
      >
      <label>Username</label>
        <Input
          type="text"
          placeholder="Username"
          style={{
            height: '45px',
            borderRadius: '5px',
            marginBottom: '5px',
          }}
          onFocus={() => handleInputFocus('username')}
        />

        <label>Email address</label>
        <Input
          type="email"
          placeholder="Email "
          style={{
            height: '45px',
            borderRadius: '5px',
            marginBottom: '10px',
          }}
          onFocus={() => handleInputFocus('email')}
        />

      <label>Phone number</label>
        <Input
          type="number"
          placeholder="Phone number"
          style={{
            height: '45px',
            borderRadius: '5px',
            marginBottom: '10px',
          }}
          onFocus={() => handleInputFocus('phoneNumber')}
        />

     
      <label>Password</label>
        <Input.Password 
          placeholder="Password" 
          style={{ marginBottom: '10px' }}
          
          />

      <label>Retype Password</label>
        <Input.Password
          placeholder="Retype Password"
          iconRender={(visible) => (visible ? <EyeTwoTone /> : <EyeInvisibleOutlined />)}
          style={{ marginBottom: '10px' }}
          
          
        />

      <label>Date of Birth</label>
      <br></br>
        <DOB/>

     <br></br>
        <label style={{marginTop:'10px'}}> Gender</label>
      <br></br>
        <Gender/>  
      </Modal>
    </div>
  );
};


export default SignUpModal;

// import React, { useState } from 'react';
// import { Button, Modal, Input } from 'antd';
// import { EyeTwoTone, EyeInvisibleOutlined } from '@ant-design/icons';
// import './SignUp.css';
// import DOB from './DatePicker';
// import Gender from './Gender';

// const SignUpModal = () => {
//   const [isModalOpen, setIsModalOpen] = useState(false);
//   const [activeInput, setActiveInput] = useState('');
//   const [password, setPassword] = useState('');
//   const [retypePassword, setRetypePassword] = useState('');
//   const [passwordMatch, setPasswordMatch] = useState(true);

//   const showModal = () => {
//     setIsModalOpen(true);
//   };

//   const handleOk = () => {
//     // Perform validation before signing up
//     if (password !== retypePassword) {
//       setPasswordMatch(false);
//       return;
//     }

//     // Continue with sign up process
//     setIsModalOpen(false);
//   };
//   const handleCancel = () => {
//     setIsModalOpen(false);
//   };

//   const handleInputFocus = (inputName) => {
//     setActiveInput(inputName);
//   };

//   const handlePasswordChange = (e) => {
//     setPassword(e.target.value);
//     setPasswordMatch(true);
//   };

//   const handleRetypePasswordChange = (e) => {
//     setRetypePassword(e.target.value);
//     setPasswordMatch(true);
//   };

//   return (
//     <div className="signupbutton">
//       <Button
//         type="green-6"
//         onClick={showModal}
//         style={{
//           color: 'white',
//           fontWeight: 'bold',
//           fontSize: '17px',
//           width: '100%',
//           height: '20px',
//           marginBottom: '10px',
//           alignItems: 'center',
//           background: 'transparent',
//           border: 'none',
//           transition: 'color 0.3s ease',
//         }}
//         className="create-button"
//       >
//         Create New Account
//       </Button>
//       <Modal
//         title="Sign Up"
//         visible={isModalOpen}
//         onOk={handleOk}
//         onCancel={handleCancel}
//         okButtonProps={{ type: 'primary' }}
//         okText="Sign Up"
//       >
//         <label>Username</label>
//         <Input
//           type="text"
//           placeholder="Create username"
//           style={{
//             height: '45px',
//             borderRadius: '5px',
//             marginBottom: '5px',
//           }}
//           onFocus={() => handleInputFocus('username')}
//         />

//         <label>Email address</label>
//         <Input
//           type="email"
//           placeholder="Enter your email "
//           style={{
//             height: '45px',
//             borderRadius: '5px',
//             marginBottom: '10px',
//           }}
//           onFocus={() => handleInputFocus('email')}
//         />

//         <label>Phone number</label>
//         <Input
//           type="number"
//           placeholder="Enter your phone number"
//           style={{
//             height: '45px',
//             borderRadius: '5px',
//             marginBottom: '10px',
//           }}
//           onFocus={() => handleInputFocus('phoneNumber')}
//         />

//         <label>Password</label>
//         <Input.Password
//           placeholder="Create a new password"
//           style={{ marginBottom: '10px' }}
//           value={password}
//           onChange={handlePasswordChange}
       
//           />

//         <label>Retype Password</label>
//         <Input.Password
//           placeholder="Retype password"
//           iconRender={(visible) => (visible ? <EyeTwoTone /> : <EyeInvisibleOutlined />)}
//           style={{ marginBottom: '10px' }}
//           value={retypePassword}
//           onChange={handleRetypePasswordChange}
//         />
//         {!passwordMatch && (
//           <div style={{ color: 'red', marginTop: '5px' }}>
//             Passwords do not match. Please retype your password correctly.
//           </div>
//         )}

//         <label>Date of Birth</label>
//         <br />
//         <DOB />

//         <br />
//         <label style={{ marginTop: '10px' }}> Gender</label>
//         <br />
//         <Gender />
//       </Modal>
//     </div>
//   );
// };

// export default SignUpModal;
