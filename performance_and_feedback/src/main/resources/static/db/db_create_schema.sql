--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    name character varying(255)
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: evaluation_duration_master; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.evaluation_duration_master (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    end_date date,
    evaluation_duration integer,
    org_id bigint NOT NULL,
    start_date date,
    title character varying(255) NOT NULL,
    uid uuid NOT NULL
);


ALTER TABLE public.evaluation_duration_master OWNER TO postgres;

--
-- Name: form_template; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.form_template (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    name character varying(255) NOT NULL,
    org_id bigint NOT NULL
);


ALTER TABLE public.form_template OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: key_performance_group_master; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.key_performance_group_master (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    label character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    org_id bigint NOT NULL,
    weightage double precision
);


ALTER TABLE public.key_performance_group_master OWNER TO postgres;

--
-- Name: key_performance_indicators_labels; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.key_performance_indicators_labels (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    description character varying(255),
    label character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    key_performance_indicators_master_id bigint NOT NULL
);


ALTER TABLE public.key_performance_indicators_labels OWNER TO postgres;

--
-- Name: key_performance_indicators_master; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.key_performance_indicators_master (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    description character varying(255),
    label character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    org_id bigint NOT NULL,
    supporting_header_text character varying(255),
    key_performance_group_master_id bigint
);


ALTER TABLE public.key_performance_indicators_master OWNER TO postgres;

--
-- Name: performance_feedback_form; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.performance_feedback_form (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    comments character varying(255),
    lock_date date NOT NULL,
    org_id bigint NOT NULL,
    publish_date date NOT NULL,
    status integer NOT NULL,
    uid uuid NOT NULL,
    year integer NOT NULL,
    form_template_id bigint NOT NULL,
    user_perf_evaluation_duration_master_id bigint
);


ALTER TABLE public.performance_feedback_form OWNER TO postgres;

--
-- Name: task; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.task (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    description character varying(255),
    is_done boolean,
    target_date timestamp without time zone
);


ALTER TABLE public.task OWNER TO postgres;

--
-- Name: user_performance_data; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_performance_data (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    comment1 character varying(255),
    comment2 character varying(255),
    "order" integer NOT NULL,
    org_id bigint NOT NULL,
    time_approved integer,
    time_spent integer NOT NULL,
    timeline_index character varying(255),
    uid uuid NOT NULL,
    user_uid bigint NOT NULL,
    evaluation_duration_master_id bigint NOT NULL,
    key_performance_indicators_labels_id bigint NOT NULL,
    user_performance_feedback_form_id bigint NOT NULL
);


ALTER TABLE public.user_performance_data OWNER TO postgres;

--
-- Name: user_performance_feedback_form; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_performance_feedback_form (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    email_notified boolean DEFAULT false NOT NULL,
    manager_uid bigint,
    normalizer_uid bigint,
    org_id bigint NOT NULL,
    status integer NOT NULL,
    uid uuid NOT NULL,
    user_uid bigint NOT NULL,
    performance_feedback_form_id bigint NOT NULL
);


ALTER TABLE public.user_performance_feedback_form OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    created_by bigint,
    creation_date timestamp without time zone,
    last_modified_by bigint,
    last_modified_date timestamp without time zone,
    is_active boolean NOT NULL,
    first_name character varying(255),
    last_name character varying(255)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, name) FROM stdin;
\.


--
-- Data for Name: evaluation_duration_master; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evaluation_duration_master (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, end_date, evaluation_duration, org_id, start_date, title, uid) FROM stdin;
\.


--
-- Data for Name: form_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.form_template (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, name, org_id) FROM stdin;
\.


--
-- Data for Name: key_performance_group_master; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.key_performance_group_master (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, label, name, weightage) FROM stdin;
\.


--
-- Data for Name: key_performance_indicators_labels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.key_performance_indicators_labels (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, description, label, name, key_performance_indicators_master_id) FROM stdin;
\.


--
-- Data for Name: key_performance_indicators_master; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.key_performance_indicators_master (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, description, label, name, key_performance_group_master_id) FROM stdin;
\.


--
-- Data for Name: performance_feedback_form; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.performance_feedback_form (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, comments, lock_date, org_id, publish_date, status, uid, year, form_template_id, user_perf_evaluation_duration_master_id) FROM stdin;
\.


--
-- Data for Name: task; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.task (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, description, is_done, target_date) FROM stdin;
\.


--
-- Data for Name: user_performance_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_performance_data (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, comment1, comment2, "order", org_id, time_approved, time_spent, uid, user_uid, evaluation_duration_master_id, key_performance_indicators_labels_id, user_performance_feedback_form_id) FROM stdin;
\.


--
-- Data for Name: user_performance_feedback_form; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_performance_feedback_form (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, email_notified, manager_uid, normalizer_uid, org_id, status, uid, user_uid, performance_feedback_form_id) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, created_by, creation_date, last_modified_by, last_modified_date, is_active, first_name, last_name) FROM stdin;
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: evaluation_duration_master evaluation_duration_master_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_duration_master
    ADD CONSTRAINT evaluation_duration_master_pkey PRIMARY KEY (id);


--
-- Name: form_template form_template_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.form_template
    ADD CONSTRAINT form_template_pkey PRIMARY KEY (id);


--
-- Name: key_performance_group_master key_performance_group_master_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_performance_group_master
    ADD CONSTRAINT key_performance_group_master_pkey PRIMARY KEY (id);


--
-- Name: key_performance_indicators_labels key_performance_indicators_labels_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_performance_indicators_labels
    ADD CONSTRAINT key_performance_indicators_labels_pkey PRIMARY KEY (id);


--
-- Name: key_performance_indicators_master key_performance_indicators_master_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_performance_indicators_master
    ADD CONSTRAINT key_performance_indicators_master_pkey PRIMARY KEY (id);


--
-- Name: performance_feedback_form performance_feedback_form_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.performance_feedback_form
    ADD CONSTRAINT performance_feedback_form_pkey PRIMARY KEY (id);


--
-- Name: task task_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.task
    ADD CONSTRAINT task_pkey PRIMARY KEY (id);


--
-- Name: evaluation_duration_master uk_1w3e0pphbepsowpjj70sgvdx5; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.evaluation_duration_master
    ADD CONSTRAINT uk_1w3e0pphbepsowpjj70sgvdx5 UNIQUE (uid);


--
-- Name: user_performance_feedback_form uk_4ujtnieqagipvkb6kuct9w751; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_performance_feedback_form
    ADD CONSTRAINT uk_4ujtnieqagipvkb6kuct9w751 UNIQUE (uid);


--
-- Name: performance_feedback_form uk_d90tyg6lu7018ko0xv8btji4l; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.performance_feedback_form
    ADD CONSTRAINT uk_d90tyg6lu7018ko0xv8btji4l UNIQUE (uid);


--
-- Name: form_template uk_dhfydwjcgxtj8y5jdwtsb5x5g; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.form_template
    ADD CONSTRAINT uk_dhfydwjcgxtj8y5jdwtsb5x5g UNIQUE (name);


--
-- Name: user_performance_data uk_j1876svu3rh79fohgo1af5ad0; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_performance_data
    ADD CONSTRAINT uk_j1876svu3rh79fohgo1af5ad0 UNIQUE (uid);


--
-- Name: user_performance_data user_performance_data_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_performance_data
    ADD CONSTRAINT user_performance_data_pkey PRIMARY KEY (id);


--
-- Name: user_performance_feedback_form user_performance_feedback_form_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_performance_feedback_form
    ADD CONSTRAINT user_performance_feedback_form_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: performance_feedback_form fk1ksaflqv86yuqrv9wpt441dci; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.performance_feedback_form
    ADD CONSTRAINT fk1ksaflqv86yuqrv9wpt441dci FOREIGN KEY (user_perf_evaluation_duration_master_id) REFERENCES public.evaluation_duration_master(id);


--
-- Name: user_performance_data fkbjdlj6prrtgum9pjopbwfdddr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_performance_data
    ADD CONSTRAINT fkbjdlj6prrtgum9pjopbwfdddr FOREIGN KEY (evaluation_duration_master_id) REFERENCES public.evaluation_duration_master(id);


--
-- Name: key_performance_indicators_labels fkdljcutoo4dk6hft9j48enhjwo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_performance_indicators_labels
    ADD CONSTRAINT fkdljcutoo4dk6hft9j48enhjwo FOREIGN KEY (key_performance_indicators_master_id) REFERENCES public.key_performance_indicators_master(id);


--
-- Name: performance_feedback_form fkf9t1eusgdshe5amacynx0pisb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.performance_feedback_form
    ADD CONSTRAINT fkf9t1eusgdshe5amacynx0pisb FOREIGN KEY (form_template_id) REFERENCES public.form_template(id);


--
-- Name: user_performance_feedback_form fkfx1cns74o3vi5hrtj80kdp5i8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_performance_feedback_form
    ADD CONSTRAINT fkfx1cns74o3vi5hrtj80kdp5i8 FOREIGN KEY (performance_feedback_form_id) REFERENCES public.performance_feedback_form(id);


--
-- Name: user_performance_data fkrb1qhd7oftffjlgvv4h5f15d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_performance_data
    ADD CONSTRAINT fkrb1qhd7oftffjlgvv4h5f15d FOREIGN KEY (user_performance_feedback_form_id) REFERENCES public.user_performance_feedback_form(id);


--
-- Name: user_performance_data fks4ethe0gn5edomyuw5n98gqjd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_performance_data
    ADD CONSTRAINT fks4ethe0gn5edomyuw5n98gqjd FOREIGN KEY (key_performance_indicators_labels_id) REFERENCES public.key_performance_indicators_labels(id);


--
-- Name: key_performance_indicators_master fks4gojqpfxa8lamxyb7t3nccwi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.key_performance_indicators_master
    ADD CONSTRAINT fks4gojqpfxa8lamxyb7t3nccwi FOREIGN KEY (key_performance_group_master_id) REFERENCES public.key_performance_group_master(id);


--
-- PostgreSQL database dump complete
--

