# INSERT INTO design (design_version, design_name, is_editable) VALUES
#     ('Version 1', 'Design 1', true),
#     ('Version 2', 'Design 2', true),
#     ('Version 3', 'Design 3', false);
#
# INSERT INTO users (email, first_name, last_name, employee_id) VALUES
#     ('john.doe@example.com', 'John', 'Doe', '123456'),
#     ('jane.doe@example.com', 'Jane', 'Doe', '654321');
#     ('mike@example.com', 'Mike', 'John', '145654');
#     ('foo.doe@example.com', 'Foo', 'Bar', '1977421');
#
# INSERT INTO design_approvals (fully_approved, level_1_approval, level_2_approval, level_3_approval, design_id) VALUES
#     (true, 'John Doe', 'Jane Doe', 'Bob Smith', 1),
#     (false, 'Jane Doe', '', '', 2),
#     (false, '', '', '', 3);
