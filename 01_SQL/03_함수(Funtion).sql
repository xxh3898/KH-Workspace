/*

    <함수 FUNTION>
    전달된 컬럼값을 읽어들여서 함수(기능)을 실행한 결과를 반환
    
    - 단일행 함수: N개의 값을 읽어들여 N개의 결과값을 리턴(매행마다 함수실행 결과를 반환)
    - 그룹함수: N개의 값을 읽어들여 1개의 결과값을 리턴(그룹을 지어 그룹별로 함수 실행 결과를 반환)
    >> SELECT 절에 단일행 함수와 그룹함수를 함깨 사용할 수 없다.
    왜? 결과 행의 갯수가 서로 다르기 때문에
    
    >> 함수를 사용할 수 있는 위치: SELECT, WHERE, ORDERY BY, GROUP BY, HAVING절

*/

----------------------------- 단일행 함수 -----------------------------

/*

    <문자처리함수>
    *LANGTH(컬럼 | '문자열'): 해당 문자열의 글자수를 반환
    *LANGTHB(컬럼 | '문자열'): 해당 문자열의 바이트수 반환
    
    '최' '나' 'ㄱ' 한글은 글자당 3BYTES
    영문자, 숫자, 특수문자는 글자당 1BYTES
    
*/

select length('오라클'), lengthb('오라클') from dual;
select length('Oracle'), lengthb('Oracle') from dual;
select emp_name, length(emp_name), length(email) from employee;

----------------------------------------------------------------------

/*

    *INSTR
    문자열로부터 특정 문자의 시작위치를 찾아서 반환
    
    instr(컬럼 | '문자열', '찾고자하는 문자', ['찾을 위치의 시작값', 순번]) -> 결과는 NUMBER

*/

select instr('AABAACAABBAA', 'B', 1) from dual;
select instr('AABAACAABBAA', 'B', -1) from dual;
select instr('AABAACAABBAA', 'B', 1, 3) from dual;

select email, instr(email, '@') 위치 from employee;

--------------------------------------------------------------------------

/*

    *SUBSTR
    문자열에서 특정 문자열을 추출해서 반환
    
    [표현법]
    SUBSTR(컬럼 | '문자열', 추출 시작위치, [추출문자 갯수])

*/

select substr('showmethemoney', 7) from dual;

select emp_name, emp_no, substr(emp_no, 8, 1) 성별 from employee;

-- 사원들 중 여자사원들만 이름과 주민등록번호를 조회
select emp_name, emp_no  from employee where substr(emp_no, 8, 1) in ('1','3');

-- 함수 중첩사용 가능
-- 이메일_아이디부분만 추출
select emp_name, email, substr(email, 1, instr(email, '@')-1) from employee;

--------------------------------------------------------------------------

/*

    *LPAD / RPAD
    문자열을 조회할 때 통일감있게 조회하고자 정렬을 하는 함수
    
    [표현법]
    LPAD / RPAD(문자열, 최종적으로 최종적으로 반환할 문자열의 길이, [덧붙이고자하는 문자])

*/

-- 30만큼의 길이 중 email칼럼 값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다
select emp_name, lpad(email, 30) from employee;

select emp_name, lpad(email, 30, '%') from employee;
select emp_name, rpad(email, 30) from employee;

-- 사원들의 사원명, 주민등록번호("123456-1XXXXXX")
select emp_name,rpad(substr(emp_no, 1, 8), 14, 'X') from employee;

---------------------------------------------------------------------------

/*

    LTRTM/RTRTM
    문자열에서 특정 문자를 제거한 나머지를 반환
    
    [표현법]
    LTRTM/RTRTM(컬럼 | '문자열', [제거하고 싶은 문자들])
    
    문자열의 왼쪽 또는 오른쪽에서 제거하고자하는 문자들을 찾아서 제거한 나머지 문자열 반환

*/

select LTRTM('    K      H        ') from dual; -- 앞에서부터 다른 문자가 나올 때까지 공백을 제거
select RTRTM('1234KH123','123') from dual; -- 제거하고자하는 문자는 문자열이 아닌 문자들

/*

    TRTM
    문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
    TRIM([LEADING | TRAILING | BOTH]) 제거하고자하는 문자열 from 문자열

*/

select TRIM('   k      h   ') from dual;
select TRIM(BOTH 'd' from ' ddddddddddddddd K    h ddddd  ') from dual;

/*

    LOWER / UPPER / INITCAP
    LOWER: 모든 문자열을 소문자로 변경해서 반환
    UPPER: 모든 문자열을 대문자로 변경해서 반환
    INITCAP: 띄어쓰기 기준 첫 글자마다 대문자로 변경한 문자열 반환

*/

select LOWER('welcom to My HK') from dual;
select uppER('welcom to My HK') from dual;

--------------------------------

/*

    *CONCAT
    문자열 두 개 전달받아서 하나로 합친 후 반환
    CONCAT(STR1, STR2)

*/

select concat('가나다', 'abc') from dual;
select ('가나다' || 'abc') from dual;

/*

    *REPLACE
    특정문자열에서 특정부분을 다른 부분으로 교체
    REPLACE(문자열, 찾을 문자열, 치환할 문자열)

*/

select email, REPLACE(email, 'C##SERVER', 'kh') from employee;

------------------------------------------------------------

/*

    <숫자처리함수>
    *ABS
    숫자의 절대값을 구하는 함수

*/

select abs(-10), abs(10) from dual;

------------------------------------------------------------

/*

    *MOD
    두 수를 나눈 나머지값을 반환
    MOD(값, 나눌값)

*/

select mod(10.9, 3) from dual;

------------------------------------------------------------

/*

    ROUND
    반올림한 결과를 반환
    ROUND(값, [위치])

*/

select ROUND(123.456, 2) from dual; -- 위치 값이 양수로 증가할수록 소수점 뒤로 한 칸씩 이동한다.
select ROUND(123.456, -1) from dual; -- 위치 값이 음수로 감소할수록 소수점 앞으로 한 칸씩 이동한다.

------------------------------------------------------------

/*

    *CEIL
    올림처리를 위한 함수
    CEIL(값)

*/

select ceil(123.456) from dual;

------------------------------------------------------------

/*

    TRUNC, FLOOR
    버림처리함수
    
    TRUNC(값, 위치)
    FLOOR(값)

*/

select trunc(123.456) from dual;
select trunc(123.456, 1) from dual;
select trunc(123.456, -1) from dual;

------------------------------------------------------------

/*

    <날짜처리함수>

*/
--  SYSDATE : 시스템의 현재 날짜 및 시간을 반환
select SYSDATE from dual;

-- MONTHS_BETWEEN : 두 날짜 사이의 개월 수
-- 사원들의 사원명, 입사일, 근무일수, 근무 개월수
select emp_name, hire_date, floor(sysdate - hire_date), ceil(months_between (sysdate, hire_date)) from employee;

-- ADD_MONTHS : 특정 날짜에 개월수를 더한 값을 반환
select add_months(sysdate, 7) from dual;

-- 사원테이블에서 사원명, 입사일, 수습기간 종료일(입사일로부터 3개월 뒤) 조회
select emp_name, hire_date, add_months(hire_date, 3) from employee;

-- NEXT_DAY(DATE, 요일(문자 | 숫자)) : 특정 날짜 이후 가장 가까운 요일의 날짜를 반환
-- 1: 일 ~ 7: 토 (오라클)

select next_day(sysdate, 7) from dual;

alter session set nls_language = korean;

-- LAST_DAY(DATE) : 해당 월의 마지막 날짜를 구해서 반환
select LAST_DAY(sysdate) from dual;

/*

    EXTRACT : 특정 날짜로부터 년|월|일| 값만 추출해서 반환
    
    [표현법]
    EXTRACT(YEAR FROM DATE) : 연도만 추출
    EXTRACT(MONTH FROM DATE) : 월만 추출
    EXTRACT(DAY FROM DATE) : 일만 추출

*/

-- 사원의 사원명,입사년도, 입사월, 입사일 조회
select emp_name, hire_date, EXTRACT(YEAR FROM hire_date), EXTRACT(MONTH FROM hire_date), EXTRACT(DAY FROM hire_date) from employee;

------------------------------------------------------------------------

/*

    <형변환 함수>
    *TO_CHAR : 숫자타입 또는 날짜타입의 값을 문자타입으로 변환시켜주는 함수
    
    [표현법]
    TO_CHAR(숫자 | 문자, [포맷])

*/

select to_char(1233) from dual;

select to_char(12, '9999') from dual;  -- 9의 자리수만큼 공간 확보
select to_char(12, '0000') from dual;  -- 0의 자리수만큼 공간 확보 후 빈칸을 0으로 채움
select to_char(12, 'L9999') from dual;
select to_char(1225433, '9,999,999') from dual;

-- 날짜타입 -> 문자타입
select to_char(sysdate, 'HH:MI:SS')from dual;
select to_char(sysdate, 'HH"시 "MI"분 "SS"초"')from dual;
select to_char(sysdate, 'YYYY-MM-DD HH"시 "MI"분 "SS"초"')from dual;

-- 년도와 관련된 포맷
select to_char(sysdate, 'yyyy'), to_char(sysdate, 'rrrr'), to_char(sysdate, 'yy'), to_char(sysdate, 'year') from dual;
select to_date('60', 'YY'), -- YY 항상 입력 그대로 해석 -> 현재년도를 반영
        to_date('60', 'RR') -- 두 자리 입력시 현재 세기를 기준으로 자동보정
        FROM dual;
        
-- 월과 관련된 포맷
select to_char(sysdate, 'MM'),
        to_char(sysdate, 'MON'),
        to_char(sysdate, 'MONTH')
        from dual;
        
-- 일과 관련된 포맷
select to_char(sysdate, 'DDD'), -- 오늘이 이번년도 몇 먼째 일수
        to_char(sysdate, 'DD'), -- 오늘 일자
        to_char(sysdate, 'D') -- 요일
        from dual;
        
-- 요일과 관련된 포맷
select to_char(sysdate, 'D'),
        to_char(sysdate, 'DAY'),
        to_char(sysdate, 'DY')
        from dual;
        
------------------------------------------------------------------------------

/*

    TO_DATE : 숫자타입 또는 문자타입을 날짜타입으로 변경하는 함수
    
    TO_DATE(숫자 | 문자, [포맷]) -> DATE

*/

select to_date(20210101) from dual;
select to_date(521220) from dual; RR룰 적용
select to_date(021011) from dual; -- 0으로 시작하는 숫자는 없다.
select to_date('021011') from dual;
select to_date('20020110 120500', 'YYYYMMDD HHMISS') from dual;

-----------------------------------------------------------------------------

/*

    TO_NUMBER: 문자타입의 데이터를 숫자타입으로 변환해서 반환
    
    [표현법]
    TO_NUMBER(문자, [포맷])

*/

select to_number('0134145') from dual;
select to_number('100,000', '999,999') from dual;

_____________________________________________________________________________

/*

    <NULL처리 함수>

*/
-- NVL(컬럼, 해당컬럼이 NULL일 경우 보여줄 값
select emp_name, bonus, nvl(bonus, 0) from employee;

-- 전 사원의 이름, 보너스 포함 연봉 조회
select emp_name, (salary + (salary*nvl(bonus, 0)))*12 from employee;
-- NVL2(컬럼, 반환값1, 반환값2)
-- 반환값1: 해당컬럼이 존재하면 보여줄 값
-- 반환값2: 해당컬럼이 존재하지 않으면 보여줄 값
select emp_name, bonus, nvl2(bonus, 'O', 'X') from employee;

--NULLIF(비교대상1, 비고대상2)
-- 두 값이 일치하면 NULL반환, 일치하지 않으면 비교대상1 반환
select nullif('123', '123') from dual;
select nullif('123', '435') from dual;

 --------------------------------------------------------------------------
 
 /*
 
    [선택함수]
    DECODE(비교하고자하는 대상, 비교값1, 결과값1, 비교값2, 결과값2, ...)
 
 */
 
 -- 사번, 사원명, 주문등록번호, 성별
 select emp_id, emp_name, emp_no, decode(substr(emp_no, 8 , 1), '1', '남', '2', '여', '3', '남', '4', '여') from employee;
 
 -- 직원의 이름, 기존급여, 인상된 급여 조회(각 직급별로 차등인상)
 -- 직급이 J7은 급여를 10%인상
 -- 직급이 J6은 급여를 15%인상
 -- 직급이 J5은 급여를 20%인상
 -- 그외 직급은 급여를 5%인상
 select emp_name, salary "인상 전" , decode(job_code, 'J7', salary * 1.1, 'J6', salary * 1.15, 'J5', salary * 1.2, salary * 1.05) as "인상 후"from employee;
 
 /*
 
    CASE문
    SQL에서 조건에 따라 값을 분기하고 싶을 때 사용하는 구문
    
    [표현법]
    CASE
        WHEN 조건1 THEN 결과1
        WHEN 조건2 THEN 결과2
        . . .
        ELSE 기본결과
    END
 
 */
 
 select emp_name, salary,
    case
        when salary >= 5000000 then '시니어'
        when salary >= 3500000 then '시니어'
        else '주니어'
    end
from employee;

----------------------------------<그룹함수>-------------------------------

-- 1. SUM(숫자타입컬럼) : 해당 컬럼값들의 총 합계를 구해서 반환해주는 함수
-- 직원들의 모든 급여의 합
select sum (salary) from employee;
-- 남자사원들의 총 급여
select sum(salary) from employee where substr(emp_no, 8, 1) in ('1', '3');
-- 부서코드가 D5인 사람들의 총 연봉
select sum(salary) from employee where dept_code = 'D5';

-- 2. AVG(NUMEBER): 해당 컬럼값들의 평균을 구해서 반환
select avg(salary) from employee;

-- 3. MIN(모든 타입 가능) : 해당 컬럼값 중 가장 작은 값을 구해서 반환
select min(emp_name), min(salary), min(hire_date) from employee;

-- 4. MAX(모든 타입 가능) : 해당 컬럼값 중 가장 작은 큰값을 구해서 반환
select max(emp_name), max(salary), max(hire_date) from employee;

-- 5. COUNT(* | 컬럼 | DISTINCT 컬럼) : 해당 조건에 맞는 행의 갯수를 세서 반환
-- count(*) : 조회된 결과의 모든 행의 갯수를 반환
-- count(컬럼): 제시한 컬럼 값이 NULL이 아닌 것만 행의 수를 세서 반
-- count(DISTINST): 해당 컬럼값에서 중복을 제거한 후 행의 갯수를 세서 반환

-- 전체사원 수
select count(*) from employee;
select count(*) from employee where substr(emp_no, 8, 1) in ('2', '4');
-- 보너스를 받는 사원의 수
select count(*) from employee where bonus is not null;
-- 현재 사원들이 총 몇 개의 부서에 분포되어 있는지 알려줘
select count(distinct dept_code) from employee;

/*
select      3
from        1
where       2
order by    4
*/