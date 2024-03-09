INSERT INTO questions (id, description, technology) VALUES
('50f16d11-91fd-4262-bc73-1e8bf78aa197','Como criar uma classe em Java?','Java'),
('95956bf1-9084-4466-9856-3cff7213bc28','Explique o conceito de polimorfismo em Java','Java'),
('bc56d0f2-2265-4622-9d48-6d39d321e557','Como lidar com exceções em Java?','Java');


INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('d5bc8ad7-fa91-4d98-bc59-f32cc4c2f55b', '50f16d11-91fd-4262-bc73-1e8bf78aa197' ,false, 'Definindo uma interface em Java'),
('e21a417a-9572-4446-901b-a507876f87c9', '50f16d11-91fd-4262-bc73-1e8bf78aa197' ,false, 'Utilizando métodos estáticos'),
('903f71c0-b90a-43cc-ab63-a8dd7cab8047', '50f16d11-91fd-4262-bc73-1e8bf78aa197' ,false, 'Criando um construtor padrão'),
('1c47b1e9-825b-41ea-90a5-d4a1e98ffdba', '50f16d11-91fd-4262-bc73-1e8bf78aa197' ,true, 'Usando a palavra-chave "class"');

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('132e4537-53aa-4690-8ca9-ab0c4c06c40f', '95956bf1-9084-4466-9856-3cff7213bc28' ,false, 'Herança simples'),
('38234749-84ac-4b09-b3dd-641f2bdfb3f6', '95956bf1-9084-4466-9856-3cff7213bc28' ,false, 'Encapsulamento em Java'),
('1c4b847a-f467-4c63-a647-b9bcc169aadd', '95956bf1-9084-4466-9856-3cff7213bc28' ,false, 'Sobrecarga de métodos'),
('476010e0-94b5-40b2-94f5-297a2f243d4d', '95956bf1-9084-4466-9856-3cff7213bc28' ,true, 'Capacidade de um objeto assumir várias formas'); 

INSERT INTO alternatives (id, question_id, is_correct, description) VALUES
('3a48f371-1b28-4810-b55f-68be7f90af5a', 'bc56d0f2-2265-4622-9d48-6d39d321e557' ,false, 'Ignorando a execução'),
('b959984c-05bb-4dec-851e-ad0d7459f1a9', 'bc56d0f2-2265-4622-9d48-6d39d321e557' ,false, 'Declarando uma exceção sem tratamento'),
('99d5ee73-3c55-4d57-b400-2683278d3962', 'bc56d0f2-2265-4622-9d48-6d39d321e557' ,false, 'Utilizando a palavra-chave "finally"'),
('4befd925-4331-4510-b70d-b2bb25575e30', 'bc56d0f2-2265-4622-9d48-6d39d321e557' ,true, 'Utilizando blocos try-catch');














