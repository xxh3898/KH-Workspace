--EMPLOYEE 테이블에서 모든 사원의 이름과 급여를 조회하되, 급여가 400만 이상인 직원만 조회하세요.
select emp_name, salary from employee where salary >= 4000000;
--직급코드가 'J5' 또는 'J6'인 사원들의 이름, 급여, 직급코드를 조회하세요
select emp_name, salary, job_code from employee where job_code in ('J5', 'J6');
--사원들의 이메일 중 '@' 앞 부분만 출력하는 SQL을 작성하세요.
select emp_name, email, substr(email, 1, instr(email, '@')-1)as "이메일 앞 부분" from employee;
--보너스를 받지 않는 사원들 중에서 급여가 300만 이상인 사원의 이름, 보너스, 급여를 조회하세요.
select emp_name, bonus, salary from employee where bonus is null;
--사수가 없는 사원들의 이름, 사번, 부서코드를 조회하세요.
select emp_name, emp_id, dept_code from employee where manager_id is null;
--이름에 '연'이 포함되어 있고, 부서코드가 없는 사원의 이름과 부서코드를 조회하세요.
select emp_name, dept_code from employee where emp_name like ('%연%') and dept_code is null;
--EMPLOYEE 테이블에서 주민등록번호(emp_no)**를 이용해, 성별을 판별하여 사번, 이름, 성별을 조회하세요.
select emp_id, emp_name, decode(substr(emp_no, 8, 1),'1','남','2','여', '3', '남', '4', '여') from employee;
--전화번호가 '010'으로 시작하지 않는 사원들의 이름과 전화번호를 조회하세요.
select emp_name, phone from employee where substr(phone,1,3)!=010;
--이름이 3글자인 사원들의 사원명과 이름의 길이를 조회하세요.
select emp_name, length(emp_name) from employee where length(emp_name)=3;
--입사일로부터 3개월 뒤 수습기간 종료일을 구해서 사원의 이름, 입사일, 종료일을 조회하세요.
select emp_name, hire_date, add_months(sysdate, 3) from employee;
--현재 날짜 기준으로 7일 뒤의 날짜를 구하세요.
select sysdate + 7 from dual;
--입사한지 500일 이상된 사원들의 사번, 이름, 입사일, 근무일수를 조회하세요.
select emp_id, emp_name, hire_date, sysdate - hire_date from employee where sysdate - hire_date>=500;
--부서별 평균 급여를 계산하여 부서코드와 평균급여를 조회하세요.

--보너스를 받는 사원의 수, 보너스를 받지 않는 사원의 수를 각각 조회하세요.

--전체 사원 중에서 가장 최근에 입사한 사원의 이름과 입사일을 조회하세요.