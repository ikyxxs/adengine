DROP TABLE IF EXISTS tb_material;
CREATE TABLE tb_material
(
    `id`           BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `advert_id`    BIGINT(20) UNSIGNED NOT NULL COMMENT '广告ID',
    `weight`       TINYINT(4) UNSIGNED NOT NULL DEFAULT 1 COMMENT '权重',
    `advert_title` VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '广告标题',
    `button_text`  VARCHAR(16)         NOT NULL DEFAULT '' COMMENT '按钮文案',
    `material_img` VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '素材图链接',
    `gmt_create`   datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_advdert;
CREATE TABLE tb_advert
(
    `id`                 BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `advert_name`        VARCHAR(32)         NOT NULL DEFAULT '' COMMENT '广告名称',
    `unit_price`         INT(11) UNSIGNED    NOT NULL COMMENT '计费单价(分)',
    `start_serving_date` datetime            NOT NULL COMMENT '开始投放日期',
    `stop_serving_date`  datetime            NOT NULL COMMENT '结束投放日期',
    `serving_switch`     TINYINT(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '投放开关:0.关闭,1.开启',
    `advert_status`      TINYINT(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态:0.正常,1.无效',
    `landpage_url`       VARCHAR(255)        NOT NULL DEFAULT '' COMMENT '落地页链接',
    `gmt_create`         datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`       datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (id)
);
