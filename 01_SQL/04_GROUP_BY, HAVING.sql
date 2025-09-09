/*

    <GROUP BY>
    그룹기준을 제시할 수 있는 구문(해당 그룹기준별로 여러 그룹으로 묶을 수 있음)
    여러개의 값들을 하나의 그룹으로 묶어서 처리하는 목적으로 사용

*/

select sum(salary) from employee;
-- 그룹: 부서별
-- 각 부서별 급여 총합
select dept_code, sum(salary) from employee group by dept_code;

-- 각 부서별 사원 수
select dept_code,count(*)
from employee
group by dept_code;

select dept_code,count(*), sum(salary)
from employee
group by dept_code
order by dept_code;

-- GROUP BY절에 함수식 사용가능(그룹을 나눌 수 있는 기준만 넣어주면)
-- 남자사원과 여자사원의 수를 조회
select decode(substr(emp_no, 8, 1), '1', '남', '2', '여'), count(*)
from employee
group by substr(emp_no, 8, 1);

-- GROUP BY절에 여러 컬럼을 기수할 수 있음
-- 여러개의 커럼을 기술하면 해당 여러컬럼들 모두를 하나의 기준으로 사용함
select dept_code, job_code, count(*)
from employee
group by dept_code, job_code;

/*

    <HAVING>
    그룹에 대한 조건을 제시할 때 사용되는 구문(주로 그룹함수식을 가지고 조건을 만듬)
    
*/

-- 각 부서별 평균 급여(부서코드, 평균급여)
select dept_code, round(avg(salary))
from employee
group by dept_code;

-- 각 부서별 평균급여가 300만원 이상인 부서들만 부서코드, 평균급여조회
-- WHERE절이 GROUP BY이전에 실행되므로 해당 코드는 300만원 이상의 급여를 받는 사람을 먼저 필터링한 후 부서코드와 평균을 구한다
select dept_code, round(avg(salary))
from employee
where salary >= 3000000
group by dept_code;

select dept_code, round(avg(salary))
from employee
where salary >= 3000000
group by dept_code
having avg(salary) >= 3000000;

-- 직급별 직급코드, 총 급여합(단, 직급별 총급여합이 1000만원 이상인 직급만 조회)
select job_code, sum(salary)
from employee
group by job_code
having sum(salary) >= 10000000;
-- 부서별 보너스를 받는 사원이 없는 부서의 부서코드
select dept_code, count(bonus)
from employee
group by dept_code
having count(bonus)=0;

-------------------------------------------------------------------

/*

    select *                        -- 5
    from 테이블                      -- 1
    where 조건식                     -- 2
    group by 그룹기준 컬럼 | 함수식    -- 3
    having 조건식                    -- 4
    order by 정렬기준                -- 6
    LIMIT (오라클에서는 존재하지 않음)

*/