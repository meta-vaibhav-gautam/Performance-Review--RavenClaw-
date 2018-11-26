--
-- Data for Name: evaluation_duration_master; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evaluation_duration_master (id, title, start_date, end_date, is_active, org_id, evaluation_duration, created_by, creation_date, last_modified_by, last_modified_date, uid) FROM stdin;
2	Q2	2018-04-01	2018-06-30	t	1	1	1	2018-03-19	1	2018-03-19	698a6b66-207a-4986-9405-40eae70fcb55
1	Q1	2018-01-01	2018-03-31	t	1	1	1	2017-12-18	1	2017-12-18	6adf152b-776d-45b4-986e-faaebaa07f6f
3	Q3	2018-07-01	2018-09-30	t	1	1	1	2018-06-25	1	2018-06-25	33708701-513c-43f7-b5db-7b0aa1eb359f
4	Q4	2018-10-01	2018-12-31	t	1	1	1	2018-09-18	1	2018-09-18	9ee83349-e55f-40fe-b9f4-fc2ef4e55fa2
5	Q1	2019-01-01	2019-03-31	t	1	1	1	2018-09-18	1	2018-09-18	0ee83349-e55f-40fe-b9f4-fc2ef4e55fa3
6	Q2	2019-04-01	2019-06-30	t	1	1	1	2018-11-18	1	2018-11-18	1ee83349-e55f-40fe-b9f4-fc2ef4e55fa4
7	Q3	2019-07-01	2019-09-30	t	1	1	1	2018-11-18	1	2018-11-18	0ee83349-e05f-40fe-b9f4-fc2ef4f55fa3
8	Q1	2020-01-01	2019-03-31	t	1	1	1	2018-11-18	1	2018-11-18	0ee83359-e55f-40fe-b9f4-fc2ff4e55fa3
9	Q4	2017-10-01	2017-12-31	t	1	1	1	2017-09-18	1	2017-09-18	0ee93349-e55f-40fe-b9f4-f32ef4e55fa3
\.


--
-- Data for Name: form_template; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.form_template (id, name, is_active, created_by, creation_date, last_modified_by, last_modified_date) FROM stdin;
2	template2	t	1	2018-02-23	1	2018-02-23
1	template1	t	1	2017-11-01	1	2017-11-01
\.


--
-- Data for Name: key_performance_group_master; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.key_performance_group_master (id, org_id, name, label, weightage, is_active, created_by, creation_date, last_modified_by, last_modified_date) FROM stdin;
2	1	self_development	Self Development	25	t	1	2017-12-20	1	2017-12-20
1	1	project_performance	Project Performance	25	t	1	2017-12-20	1	2017-12-20
3	1	org_development	Organisation Development	50	t	1	2017-12-20	1	2017-12-20
\.

--
-- Data for Name: key_performance_indicators_master; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.key_performance_indicators_master (id, org_id, name, label, description, is_active, key_performance_group_master_id, supporting_header_text, created_by, creation_date, last_modified_by, last_modified_date) FROM stdin;
9	1	additional_efforts	Additional Efforts	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	\N	\N	1	2017-12-20	1	2017-12-20
8	1	achievements	Achievements	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	\N	\N	1	2017-12-20	1	2017-12-20
10	1	retrospective	Retrospective	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	\N	\N	1	2017-12-20	1	2017-12-20
1	1	project_performance	Project Performance	 	t	1	\N	1	2017-12-20	1	2017-12-20
2	1	goals	 What percentage of goals for the review period were completed satisfactorily? 	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	2	\N	1	2017-12-20	1	2017-12-20
4	1	skill_development	 What was the individual contribution towards skill development in the organization? 	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	3 	My contribution towards Skill Development in the organization? 	1	2017-12-20	1	2017-12-20
3	1	beyond_goals	 Has the individual learnt something beyond the planned goals? 	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	2	Details of learning beyond the planned goals? 	1	2017-12-20	1	2017-12-20
6	1	org_branding	 What was the individual contribution towards Organization brand building? 	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	3	My contribution towards Organization Brand Building? 	1	2017-12-20	1	2017-12-20
5	1	recruitment_development	 What was the indvidual contribution towards recruitment process? 	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	3	Mycontribution towards Recruitment Process? 	1	2017-12-20	1	2017-12-20
7	1	org_event	 What was the individual contribution towards oraganzation of events? 	You can rate efforts put by the individual based on the data provided by him/her.you could use following guidelines for converting efforts into score:20+hrs(4),15+hrs(3),10+hrs(2),5+hrs(1)	t	3	My contribution towards Organization of Events? 	1	2017-12-20	1	2017-12-20
\.

--
-- Data for Name: key_performance_indicators_labels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.key_performance_indicators_labels (id, name, label, description, key_performance_indicators_master_id, is_active, created_by, creation_date, last_modified_by, last_modified_date) FROM stdin;
26	additional_efforts	Additional Efforts	\N	9	t	1	2017-12-20	1	2017-12-20
27	went_well	Message	\N	10	t	1	2017-12-20	1	2017-12-20
28	not_well	Message	\N	10	t	1	2017-12-20	1	2017-12-20
22	A1	None	\N	8	t	1	2017-12-20	1	2017-12-20
23	A2	Got appreciation mail from client	\N	8	t	1	2017-12-20	1	2017-12-20
24	A3	Elevated to higher role	\N	8	t	1	2017-12-20	1	2017-12-20
25	A4	Got more responsibilities	\N	8	t	1	2017-12-20	1	2017-12-20
2	PP2	 Did the individual complete assigned project tasks as per given timelines? 	 Applying efforts to complete work on committed timelines.  	1	t	1	2017-12-20	1	2017-12-20
1	PP1	 Was the quality of the project deliverables produced by the individual of the required standard? 	 Code, test cases, test scripts, design document, requirements document,user stories etc. 	1	t	1	2017-12-20	1	2017-12-20
5	SD1	New certifications	\N	3	t	1	2017-12-20	1	2017-12-20
3	PP3	 Has Individual adhered with defined project / organisation processes? 	 regular updates on project / tasks tracking tools, timesheets, attendance, performance review 	1	t	1	2017-12-20	1	2017-12-20
7	SD3	Webinars attended	\N	3	t	1	2017-12-20	1	2017-12-20
6	SD2	Classroom training sessions or seminars attended	\N	3	t	1	2017-12-20	1	2017-12-20
9	SD5	Online Courses completed	\N	3	t	1	2017-12-20	1	2017-12-20
8	SD4	Technical articles read	\N	3	t	1	2017-12-20	1	2017-12-20
11	SD7	Others	\N	3	t	1	2017-12-20	1	2017-12-20
10	SD6	Professional books read	\N	3	t	1	2017-12-20	1	2017-12-20
13	SKD2	Seminars conducted	\N	4	t	1	2017-12-20	1	2017-12-20
12	SKD1	Hours of training sessions conducted(including GET sessions)	\N	4	t	1	2017-12-20	1	2017-12-20
15	RD2	Test papers corrected	\N	5	t	1	2017-12-20	1	2017-12-20
14	RD1	Interviews conducted	\N	5	t	1	2017-12-20	1	2017-12-20
17	OB1	Tech talks given on external forums	\N	6	t	1	2017-12-20	1	2017-12-20
16	RD3	Questions contibuted to recruitment process	\N	5	t	1	2017-12-20	1	2017-12-20
19	OB3	Other contribution to social media	\N	6	t	1	2017-12-20	1	2017-12-20
18	OB2	Participation in national and international conferences	\N	6	t	1	2017-12-20	1	2017-12-20
21	OE2	Cultural	\N	7	t	1	2017-12-20	1	2017-12-20
20	OE1	sports	\N	7	t	1	2017-12-20	1	2017-12-20
4	PP4	 Did the individual take the complete responsibility for the tasks assigned to him, and ensured that same completed successfully?  	 Taking ownership and responsibility of tasks. Does not need regular monitoring, and escalates risks/issues proactively 	1	t	1	2017-12-20	1	2017-12-20
\.

--
-- Data for Name: performance_feedback_form; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.performance_feedback_form (id, org_id, year, form_template_id, publish_date, lock_date, comments, status, is_active, user_perf_evaluation_duration_master_id, created_by, creation_date, last_modified_by, last_modified_date, uid) FROM stdin;
2	1	2018	1	2018-10-01	2018-12-31	\N	0	t	4	1	2018-09-29	1	2018-09-29	1e6fcf68-15c7-43dc-84f8-833ae7cd81ad
1	1	2018	2	2018-07-01	2018-09-30	\N	2	t	3	1	2018-06-28	1	2018-06-28	db984857-27bf-4a9a-b7ee-cfc56b1b937c
\.

--
-- Data for Name: user_performance_feedback_form; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_performance_feedback_form (id, org_id, manager_uid, normalizer_uid, performance_feedback_form_id, email_notified, status, user_uid, is_active, created_by, creation_date, last_modified_by, last_modified_date, uid) FROM stdin;
2	1	3	2	2	t	0	5	t	1	2018-10-01	1	2018-10-01	665465bb-23b7-4968-8b7c-eaa967648931
1	1	3	2	2	t	0	4	t	1	2018-10-01	1	2018-10-01	9fa461f1-917b-4624-94cb-bec4c4b723eb
\.

--
-- Data for Name: user_performance_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_performance_data (id, org_id, user_performance_feedback_form_id, "order", evaluation_duration_master_id, key_performance_indicators_labels_id, time_spent, user_uid, time_approved, comment1, comment2, is_active, timeline_index, created_by, creation_date, last_modified_by, last_modified_date, uid) FROM stdin;
2	1	1	1	4	11	200	4	\N	\N	\N	t	Week : 1 Oct	4	2018-10-10	4	2018-10-10	90aaa72b-732c-4e82-97fe-f90c3e9d5012
1	1	1	1	4	6	129	4	\N	\N	\N	t	Week : 1 Oct	4	2018-10-10	4	2018-10-10	4077b48f-1f63-4bd9-8ec7-d2185272ae5c
4	1	1	1	4	20	249	4	\N	\N	\N	t	\N	4	2018-10-26	4	2018-10-26	0a2c412e-7218-4a7c-abe9-9c97edab3203
3	1	1	1	4	17	190	4	\N	\N	\N	t	\N	4	2018-10-26	4	2018-10-26	db5fd80d-92c3-4745-9889-e9faa19d4a98
6	1	2	1	4	5	329	5	\N	\N	\N	t	Week : 1 Oct	5	2018-10-14	5	2018-10-14	9213d371-0c49-4a9d-9cb1-1bcd0dcda3e9
5	1	1	1	4	22	320	4	\N	\N	\N	t	Week : 1 Oct	4	2018-10-26	4	2018-10-26	68d2ea35-557b-433d-bb39-cfdea9e0d7d3
8	1	2	1	4	15	130	5	\N	\N	\N	t	\N	5	2018-10-14	5	2018-10-14	60338b99-8130-48e1-ae65-2cb6ac3d60c5
7	1	2	1	4	11	260	5	\N	\N	\N	t	Week : 1 Oct	5	2018-10-14	5	2018-10-14	d6b6ba12-244e-4bd1-8d27-09847953b90e
10	1	2	1	4	23	350	4	\N	\N	\N	t	Week : 1 Oct	5	2018-11-12	5	2018-11-12	68676bf6-77fc-48dc-8948-4ed7f184a643
9	1	2	1	4	21	149	5	\N	\N	\N	t	\N	5	2018-11-12	5	2018-11-12	b2ffe908-b845-46be-9257-be6021a867ea
\.



