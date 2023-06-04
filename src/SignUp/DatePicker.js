import { DatePicker, Space } from 'antd';
import React from 'react';

const { RangePicker } = DatePicker;

const DateSelector = () => (
  <Space direction="vertical" size={12}>
    <DatePicker
      cellRender={(current) => {
        const style = {};
        if (current.date() === 1) {
          style.border = '1px solid #1677ff';
          style.borderRadius = '50%';
          style.height = '100px';
        }
        return (
          <div className="ant-picker-cell-inner" style={style}>
            {current.date()}
          </div>
        );
      }}
    />
  </Space>
);

export default DateSelector;
