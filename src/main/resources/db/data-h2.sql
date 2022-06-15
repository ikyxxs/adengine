DELETE FROM tb_material;
INSERT INTO tb_material (advert_id, weight, advert_title, button_text, material_img)
VALUES (1, 1, '测试广告标题1', '点击', 'http://materialimg'),
       (1, 1, '测试广告标题2', '领取', 'http://materialimg'),
       (2, 1, '测试广告标题3', '点击', 'http://materialimg'),
       (2, 1, '测试广告标题4', '领取', 'http://materialimg');

DELETE FROM tb_advert;
INSERT INTO tb_advert (advert_name, unit_price, start_serving_date, stop_serving_date, serving_switch, landpage_url)
VALUES ('测试广告1', 20, '2022-06-01', '2023-06-01', 1, 'http://landpageurl'),
       ('测试广告2', 10, '2022-06-01', '2023-06-01', 1, 'http://landpageurl');
