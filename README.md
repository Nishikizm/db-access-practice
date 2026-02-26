# db-access-practice

Javaのデータベース操作習熟を目的として作成しました。

## 概要

JDBCを用いてPostgreSQLの *customers* テーブルに接続し、CRUD操作をおこなう。

**Create**: *customer_name* 、*email* 、*balance* を指定して顧客情報追加<br>
**Read**: *customer_id* を指定して顧客情報取得<br>
**Update**: *customer_id* を指定し、該当顧客の *balance* に指定値を加える<br>
**Delete**: *customer_id* を指定して顧客情報削除<br>

## テーブル

*customers* テーブルの構成

| column | data types | default value | constraints |
| ------------ | ------------ | ------------ | ------------ |
| customer_id | SERIAL | - | PRIMARY KEY |
| customer_name | VARCHAR(100) | - | NOT NULL |
| email | VARCHAR(200) | - | UNIQUE |
| balance | NUMERIC(12, 2) | 0 | NOT NULL |
| created_at | TIMESTAMP | NOW() | NOT NULL |

## CLI仕様

以下の通り引数を指定し実行する。

**Create**:  CREATE *`customer_name`* *`email`* *`balance`*<br>
**Read**:  READ *`customer_id`*<br>
**Update**:  UPDATE *`customer_id`* *`値`*<br>
**Delete**:  DELETE *`customer_id`*<br>

## 使用技術

- Java 17
- JDBC（PostgreSQL Driver）
- Maven
- PostgreSQL 16
- Docker Compose

## 補足

- BigDecimalを使った金額の取り扱いの練習のため、テーブルに *balance* を含めた。