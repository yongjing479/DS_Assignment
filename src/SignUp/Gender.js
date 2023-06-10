import { Radio } from 'antd';
import { useState } from 'react';

const Gender = () => {
  const [value, setValue] = useState(1);
  const onChange = (e) => {
    console.log('radio checked', e.target.value);
    setValue(e.target.value);
  };
  return (
    <Radio.Group onChange={onChange} value={value}>
      <Radio value={1}>Male</Radio>
      <Radio value={2}>Female</Radio>
      <Radio value={3}>Other</Radio>
      
    </Radio.Group>
  );
};
export default Gender;